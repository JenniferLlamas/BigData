//importacion de librerias a utilizar
import org.apache.spark.ml.linalg.{Matrix, Vectors}
import org.apache.spark.ml.stat.Correlation
import org.apache.spark.sql.Row
import org.apache.spark.ml.linalg.{Vector, Vectors}
import org.apache.spark.ml.stat.ChiSquareTest
import org.apache.spark.ml.stat.Summarizer



//datos a utilizar para probar el algoritmo utilizando vectores
val data = Seq(
  Vectors.sparse(4, Seq((0, 1.0), (3, -2.0))),
  Vectors.dense(4.0, 5.0, 0.0, 3.0),
  Vectors.dense(6.0, 7.0, 0.0, 8.0),
  Vectors.sparse(4, Seq((0, 9.0), (3, 1.0)))
)

//conversion de los datos  a dataframe 
val df = data.map(Tuple1.apply).toDF("features")

//correlacion de pearson
val Row(coeff1: Matrix) = Correlation.corr(df, "features").head
println(s"Pearson correlation matrix:\n $coeff1")

//matriz de correlacion
val Row(coeff2: Matrix) = Correlation.corr(df, "features", "spearman").head
println(s"Spearman correlation matrix:\n $coeff2")

/*-----------chi cuadrada para pruebas de hipotesis -------*/

//datos a utilizar para probar el algoritmo utilizando vectores
val data2 = Seq(
  (0.0, Vectors.dense(0.5, 10.0)),
  (0.0, Vectors.dense(1.5, 20.0)),
  (1.0, Vectors.dense(1.5, 30.0)),
  (0.0, Vectors.dense(3.5, 30.0)),
  (0.0, Vectors.dense(3.5, 40.0)),
  (1.0, Vectors.dense(3.5, 40.0))
)


//conversion de los datos  a dataframe 
val df2 = data2.toDF("label", "features")

//asignacion de chi cuadrada a la variable chi
val chi = ChiSquareTest.test(df2, "features", "label").head


//impresion de resultados
println(s"pValues = ${chi.getAs[Vector](0)}")
println(s"degreesOfFreedom ${chi.getSeq[Int](1).mkString("[", ",", "]")}")
println(s"statistics ${chi.getAs[Vector](2)}")


/*-----------------sumarizer---------------------------------*/
//sesion de spark
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()

import spark.implicits._
import Summarizer._
//datos a utilizar para probar el algoritmo utilizando vectores
val data3 = Seq(
  (Vectors.dense(2.0, 3.0, 5.0), 1.0),
  (Vectors.dense(4.0, 6.0, 7.0), 2.0)
)

//conversion de los datos  a dataframe 
val df3 = data3.toDF("features", "weight")


//calculo del promedio y varianza de los datos
val (meanVal, varianceVal) = df3.select(metrics("mean", "variance").summary($"features", $"weight").as("summary")).select("summary.mean", "summary.variance").as[(Vector, Vector)].first()

println(s"with weight: mean = ${meanVal}, variance = ${varianceVal}")

val (meanVal2, varianceVal2) = df.select(mean($"features"), variance($"features")).as[(Vector, Vector)].first()

//impresion de resultados
println(s"without weight: mean = ${meanVal2}, sum = ${varianceVal2}")

