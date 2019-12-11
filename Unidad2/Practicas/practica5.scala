import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator

//sesion de spark
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()

// Lectura del archivo txt
val data = spark.read.format("libsvm").load("sample_multiclass_classification_data.txt")

// Separacion de datos de prueba y datos de entrenamiento
val splits = data.randomSplit(Array(0.6, 0.4), seed = 1234L)
val train = splits(0)
val test = splits(1)

// Especifica las capas de la red neural:
val layers = Array[Int](4, 5, 4, 3)

// Instancia del algoritmo para entrenamiento
val trainer = new MultilayerPerceptronClassifier().setLayers(layers).setBlockSize(128).setSeed(1234L).setMaxIter(100)

// Entrenamiento del modelo
val model = trainer.fit(train)

// Calculo de la precision del modelo
val result = model.transform(test)
val predictionAndLabels = result.select("prediction", "label")
val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")

//impresion de resultados
println(s"Test set accuracy = ${evaluator.evaluate(predictionAndLabels)}")
