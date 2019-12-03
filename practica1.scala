
//librerias para utilizar el algoritmo kmeans
import org.apache.spark.ml.clustering.KMeans
import org.apache.spark.ml.evaluation.ClusteringEvaluator


//Sesion de spark
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder.().getOrCreate()

//lectura de archivo txt de los datos a analizar
val dataset = spark.read.format("libsvm").load("sample_kmeans_data.txt")

//variable kmeans que guarda una instancia de la clase kmeans
//setk que recibe parametro de k (vecinos) a considerar
val kmeans = new KMeans().setK(2).setSeed(1L)

//variable model que guarda los datos entreados
val model = kmeans.fit(dataset)

// Variable predictions que guarda las predicciones del modelo
val predictions = model.transform(dataset)

// Variable evaluator que guarda una instancia de la clase ClusteringEvaluator
val evaluator = new ClusteringEvaluator()

//variable silhouette que guarda la evaluacion de las predicciones
val silhouette = evaluator.evaluate(predictions)
println(s"Silhouette with squared euclidean distance = $silhouette")

// Impresion de los centros de los clustering
println("Cluster Centers: ")
model.clusterCenters.foreach(println)
