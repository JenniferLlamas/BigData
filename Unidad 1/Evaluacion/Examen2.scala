println("Inicio de Sesion")
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()

println("Cargando CSV Netflix")
val df = spark.read.option("header","true").option("inferSchema","true")csv("Netflix_2011_2016.csv")

println("Nombres de Columnas")
df.columns

println("Esquema")
df.printSchema()

println("Primeras filas")
df.head(5)

for(data<- df.head(5)){
   println(data)
}
println("Imprimiendo DataFrame")
df.describe().show()
println("Creacion de Columna HV Radio")
val df2 = df.withColumn("HV Radio", df("High")/df("Volume"))

println("ESquema del nuevo DataFrame")
df2.printSchema()

println("Volumen Maximo")
df.select(max($"Volume")).show()
println("Volume Minimo")
df.select(min($"Volume")).show()

println("Close menor a 600")
df.select($"Close"< 600).count()


val totalC = df.filter($"High" > 500 ).count()
var porcentaje = (totalC * 100).toDouble / df.count().toDouble
println(s"Porcentaje de High mayor a 500: $porcentaje")


println("Correlacion de Pearson")
df.select(corr($"High",$"Volume")).show()

println("Maximo de High por año")
df.groupBy(year($"Date")).avg("High").orderBy(year($"Date")).show()

println("Promedio de Close por mes")
df.groupBy(month($"Date")).max("High").orderBy(month($"Date")).show()

