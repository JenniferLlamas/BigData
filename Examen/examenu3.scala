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
//seleccion de caracteristicas para evaluar
var feature_data = dataset.select("Fresh","Milk","Grocery","Frozen","Detergents_Paper","Delicassen")


//librerias para crear vector features_data
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors

//librerias para convertir campo string a double
import org.apache.spark.ml.attribute.Attribute
import org.apache.spark.ml.feature.{IndexToString, StringIndexer}
//----Transformacion de las columnas
//creacion de una nueva columna Fresh para asignar un valor numerico a la columna Fresh
val indexer = new StringIndexer().setInputCol("Fresh").setOutputCol("FreshIndex").fit(feature_data)
var indexed = indexer.transform(feature_data)
indexed.show(5)
val indexer2 = new StringIndexer().setInputCol("Milk").setOutputCol("MilkIndex").fit(feature_data)
var indexed = indexer2.transform(feature_data)
indexed.show(5)
val indexer3 = new StringIndexer().setInputCol("Grocery").setOutputCol("GroceryIndex").fit(feature_data)
var indexed = indexer3.transform(feature_data)
indexed.show(5)
val indexer4 = new StringIndexer().setInputCol("Frozen").setOutputCol("FrozenIndex").fit(feature_data)
var indexed = indexer4.transform(feature_data)
indexed.show(5)
val indexer5 = new StringIndexer().setInputCol("Detergents_Paper").setOutputCol("Detergents_Paper_Index").fit(feature_data)
var indexed = indexer5.transform(feature_data)
indexed.show(5)
val indexer6 = new StringIndexer().setInputCol("Delicassen").setOutputCol("DelicassenIndex").fit(feature_data)
var indexed = indexer6.transform(feature_data)
indexed.show(5)
//caracteristicas a incluir en el vector
val features = Array("FreshIndex","MilkIndex","GroceryIndex","FrozenIndex","Detergents_PaperIndex","DelicassenIndex")

//creacion de vector assember con las caracteristicas seleccionadas	
val assembler = new VectorAssembler().setInputCols(features)


//transformacion del vector al dataset
val dataset2 = assembler.transform(feature_data)


//-------------------KMEANS--------------------------------------
//Entrenamiento de modeo kmeans CON K=3
val kmeans = new KMeans().setK(3).setSeed(1L)
val model = kmeans.fit(dataset2)

// Calculo de error
val WSSSE = model.computeCost(dataset2)
println(s"Within Set Sum of Squared Errors = $WSSSE")

// Impresion de los centroides
println("Cluster Centers: ")
model.clusterCenters.foreach(println)
