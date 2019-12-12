//importacion de librerias para algoritmo multilayer perceptron
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator


//librerias para crear vector features
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors

//librerias para convertir campo string a double
import org.apache.spark.ml.attribute.Attribute
import org.apache.spark.ml.feature.{IndexToString, StringIndexer}

//sesion de spark
import org.apache.spark.sql.SparkSession
import spark.implicits._
val spark = SparkSession.builder().getOrCreate()

// Lectura del archivo csv
//val data = spark.read.format("libsvm").load("iris.csv")

val data = spark.read.option("header", "true").option("inferSchema","true")csv("iris.csv")

//creacion de una nueva columna label para asignar un valor numerico a la columna species
val indexer = new StringIndexer().setInputCol("species").setOutputCol("label").fit(data)

//transformacion del dataframe a un nuevo dataframe con los datos doubles
val indexed = indexer.transform(data)
indexed.show(5)

//nuevo dataframe con columnas con tipos de datos double
val df = indexed.select("sepal_length","sepal_width","petal_length","petal_width","label")

val label = indexed.select("label")  
df.show(5)


//columnas a añadir al vector features
val features = Array("sepal_length","sepal_width","petal_length","petal_width")

//creacion del vector features	
val assembler = new VectorAssembler().setInputCols(features).setOutputCol("features")


val df2 = assembler.transform(df)

val output = df2.select("label","features")

output.show(5)

//------------------MULTILAYER PERCEPTRON--------------------------------
// Separacion de datos de prueba y datos de entrenamiento
val splits = output.randomSplit(Array(0.6, 0.4), seed = 1234L)
val train = splits(0)
val test = splits(1)

// Especifica las capas de la red neural:
//3 neuronas de entrada
//dos o mas ocultas, en este caso 2 y 1
//3 neuronas de salida
val layers = Array[Int](3, 2, 1, 3)

// Instancia del algoritmo para entrenamiento
val trainer = new MultilayerPerceptronClassifier().setLayers(layers).setBlockSize(128).setSeed(1234L).setMaxIter(100)

// Entrenamiento del modelo
val model = trainer.fit(train)

//calculo del resultado con los datos de prueba
val result = model.transform(test)

val predictionAndLabels = result.select("prediction", "label")
predictionAndLabels.show(5)
val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")

//impresion de resultados
println(s"Test set accuracy = ${evaluator.evaluate(predictionAndLabels)}")