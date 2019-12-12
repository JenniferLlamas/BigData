# BigData

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
