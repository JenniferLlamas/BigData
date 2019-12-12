// Libreria para inicio de sesion spark
import org.apache.spark.sql.SparkSession

// Libreria para minimizar errores
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)

// Inicion de Sesion Spark
val spark = SparkSession.builder().getOrCreate()

// Libreria para el uso del algoritmo kmeans
import org.apache.spark.ml.clustering.KMeans

// Lectura de archivo csv
val dataset = spark.read.option("header", "true").option("inferSchema","true")csv("Wholesale customers data.csv")


dataset.printSchema
dataset.columns

//librerias para crear vector features_data
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors

//caracteristicas a incluir en el vector features_data
val features_data = dataset.select("Fresh","Milk","Grocery","Frozen","Detergents_Paper","Delicassen")
val features = Array("Fresh","Milk","Grocery","Frozen","Detergents_Paper","Delicassen")

//creacion de vector assember con las caracteristicas seleccionadas	
val assembler = new VectorAssembler().setInputCols(features).setOutputCol("features")

//transformacion del vector al dataset
val dataset2 = assembler.transform(features_data)
dataset2.show(5)

val data = dataset2.select("features")
data.show(5)
//-------------------KMEANS--------------------------------------
//Entrenamiento de modeo kmeans CON K=3
val kmeans = new KMeans().setK(3).setSeed(1L)
val model = kmeans.fit(data)

// Calculo de error
val WSSSE = model.computeCost(data)
println(s"Within Set Sum of Squared Errors = $WSSSE")

// Impresion de los centroides
println("Cluster Centers: ")
model.clusterCenters.foreach(println)
