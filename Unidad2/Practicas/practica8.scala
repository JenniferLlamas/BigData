//librerias a utilizar
import org.apache.spark.ml.classification.NaiveBayes
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
//Sesion de spark
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder.appName("NaiveBayesExample").getOrCreate()

val data = spark.read.format("libsvm").load("iris_libsvm.txt")

// Separacion de datos de prueba y datos de entrenamiento
val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3), seed = 2229L)


trainingData.show()

// Entrenamiento del modelo
val model = new NaiveBayes().fit(trainingData)

//predicciones con los datos de prueba
val predictions = model.transform(testData)


// Computo del error
val evaluator = new MulticlassClassificationEvaluator().setLabelCol("label").setPredictionCol("prediction").setMetricName("accuracy")
val accuracy = evaluator.evaluate(predictions)

//impresion de la precision 
println(s"Test set accuracy = $accuracy")
