# BigData

Unidad 3 - Implementacion del Algoritmo K-means con Scala-Spark

## Concepto de Clustering

Es una técnica de aprendizaje automático que implica la agrupación de puntos de datos. Dado un conjunto de puntos de datos, podemos usar un algoritmo de agrupamiento para clasificar cada punto de datos en un grupo específico.

## Algoritmo Kmeans

K-Means es un algoritmo no supervisado de Clustering. Se utiliza cuando tenemos un montón de datos sin etiquetar. El objetivo de este algoritmo es el de encontrar «K» grupos (clusters) entre los datos crudos.

## Implementacion
```Scala
import org.apache.spark.ml.clustering.KMeans
import org.apache.spark.ml.evaluation.ClusteringEvaluator
```
## Pasos
1. Inicialización: una vez escogido el número de grupos, k, se establecen k centroides en el espacio de los datos, por ejemplo, escogiéndolos aleatoriamente.
2. Asignación objetos a los centroides: cada objeto de los datos es asignado a su centroide más cercano.
3. Actualización centroides: se actualiza la posición del centroide de cada grupo tomando como nuevo centroide la posición del promedio de los objetos pertenecientes a dicho grupo.


## Código
```Scala
val kmeans = new KMeans().setK(3).setSeed(1L)
val model = kmeans.fit(data)

// Impresion de los centroides
println("Cluster Centers: ")
model.clusterCenters.foreach(println)



## Scala Basics

This branch contains all basic commands for understand the programming languaje Scala

## Prerequisites
* Ubuntu 18 
* Use the next link to install Spark [Instalation Spark](https://computingforgeeks.com/how-to-install-apache-spark-on-ubuntu-debian/).

## Examples

### Variables
```scala
// val <name> : <type> = <literal>
// var <name> : <type> = <literal>

1 / 2  Int = 0
1.0 / 2 Double = 0.
```

### Conditions
```scala
var numero = Int : 0
if(numero !=2){
	if(numero%2){
		println(s"El numero $numero no es primo")
	}
}
else{
	println(s"El numero $numero es primo")
	
}
```

### Loops
```scala
lista+=("verde","amarillo","azul","naranja","perla")
// 3. Traer los elementos de "lista" "verde", "amarillo", "azul"
for(k<- lista){
  if(k=="rojo" || k=="verde" || k=="amarillo" || k== "azul"){
     println(k)
  }
}
```

### Print Results
```scala
val bird = "tweet"
val message = s"Estoy escribiendo un $bird"
println(message)
```