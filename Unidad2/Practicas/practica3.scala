//librerias a utilizar
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.{RandomForestClassificationModel, RandomForestClassifier}
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{IndexToString, StringIndexer, VectorIndexer}


//sesion de spark
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()
// Lectura del archivo txt
val data = spark.read.format("libsvm").load("sample_libsvm_data.txt")

//creacion de etiquetas indexadas
val labelIndexer = new StringIndexer().setInputCol("label").setOutputCol("indexedLabel").fit(data)
//establecer maximo de categorias a tomar en cuenta
val featureIndexer = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4).fit(data)

// Separacion de los datos para entrenamiento y testing
val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3))

// Entrenamiento del arbol
val rf = new RandomForestClassifier().setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures").setNumTrees(10)

val labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(labelIndexer.labels)

val pipeline = new Pipeline().setStages(Array(labelIndexer, featureIndexer, rf, labelConverter))

// Entrenamiento del modelo con los datos de prueba
val model = pipeline.fit(trainingData)

// hacer las predicciones con los datos de prueba.
val predictions = model.transform(testData)

// mostrar 5 predicciones
predictions.select("predictedLabel", "label", "features").show(5)

// Computo del error
val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")
val accuracy = evaluator.evaluate(predictions)
println(s"Test Error = ${(1.0 - accuracy)}")

//instancia del modelo del algoritmo
val rfModel = model.stages(2).asInstanceOf[RandomForestClassificationModel]

//impresion del modelo
println(s"Learned classification forest model:\n ${rfModel.toDebugString}")

