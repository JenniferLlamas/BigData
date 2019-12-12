//librerias a utilizar
import org.apache.spark.ml.classification.{LogisticRegression, OneVsRest}
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator

//sesion de spark
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()

val inputData = spark.read.format("libsvm").load("sample_multiclass_classification_data.txt")

// Separacion de datos de pruebas y datos de entrenamiento
val Array(train, test) = inputData.randomSplit(Array(0.8, 0.2))

// Instancia del algoritmo logisticRegression
val classifier = new LogisticRegression().setMaxIter(10).setTol(1E-6).setFitIntercept(true)

// Instancia del algoritmo aka
val ovr = new OneVsRest().setClassifier(classifier)

// Entrenamiento del modelo con los datos de entrenamiento
val ovrModel = ovr.fit(train)

// Predicciones del algoritmo utilizando los datos de prueba
val predictions = ovrModel.transform(test)

// Obtencionn del evaluador
val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")

// Computo  del error 
val accuracy = evaluator.evaluate(predictions)

//impresion de la precision
println(s"Test Error = ${1 - accuracy}")

