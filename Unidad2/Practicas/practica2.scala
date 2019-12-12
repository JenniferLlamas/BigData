//importacion de librerias a utilizar

import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.DecisionTreeClassificationModel
import org.apache.spark.ml.classification.DecisionTreeClassifier
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

// Separacion de datos de entrenamiento con los de prueba.
val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3))

// Entrenamiento del modelo
val dt = new DecisionTreeClassifier().setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures")

// Conversion de las etiquetas indexadas a las etiquetas originales 
val labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(labelIndexer.labels)

// Instancia de un pipeline con las etiquetas
val pipeline = new Pipeline().setStages(Array(labelIndexer, featureIndexer, dt, labelConverter))

// Entrenamiento del modelo con los datos de entrenamiento
val model = pipeline.fit(trainingData)

// Realizacion de predicciones con los datos de prueba
val predictions = model.transform(testData)

// Muestra de predicciones
predictions.select("predictedLabel", "label", "features").show(5)

// Computo del error 
val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")
val accuracy = evaluator.evaluate(predictions)
println(s"Test Error = ${(1.0 - accuracy)}")

val treeModel = model.stages(2).asInstanceOf[DecisionTreeClassificationModel]
println(s"Learned classification tree model:\n ${treeModel.toDebugString}")
