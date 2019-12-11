import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.{GBTClassificationModel, GBTClassifier}
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{IndexToString, StringIndexer, VectorIndexer}


//sesion de spark
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()

// Lectura del archivo txt
val data = spark.read.format("libsvm").load("sample_libsvm_data.txt")

//creacion de etiquetas indexadas
val labelIndexer = new StringIndexer().setInputCol("label").setOutputCol("indexedLabel").fit(data)
val featureIndexer = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4).fit(data)

// Separacion de los datos para entrenamiento y para pruebas
val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3))

// Entrenamiento del modelo
val gbt = new GBTClassifier().setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures").setMaxIter(10).setFeatureSubsetStrategy("auto")

// Conversion de los etiquetas indices 
val labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(labelIndexer.labels)

// Instancia de un pipeline con las etiquetas
val pipeline = new Pipeline().setStages(Array(labelIndexer, featureIndexer, gbt, labelConverter))

// Entrenamiento del modelo 
val model = pipeline.fit(trainingData)

// Realizacion de pruebas con el modelo
val predictions = model.transform(testData)

// Mostrar predicciones del modelo
predictions.select("predictedLabel", "label", "features").show(5)

// Computo del error
val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")
val accuracy = evaluator.evaluate(predictions)
println(s"Test Error = ${1.0 - accuracy}")

//instancia del modelo del algoritmo 
val gbtModel = model.stages(2).asInstanceOf[GBTClassificationModel]

//impresion del modelo
println(s"Learned classification GBT model:\n ${gbtModel.toDebugString}")
