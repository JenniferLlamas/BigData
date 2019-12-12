/*
-------------------------
PRACTICA 1
-------------------------
BIG DATA
-------------------------
*/

//1. Desarrollar un algoritmo en scala que calcule el radio de un circulo
//RADIO= CIRCUNFERENCIA/2PI
val radio = Double : 0.0
val circunferencia = Int : 10
var radio = circunferencia/(2* 3.1416)
println(s"El radio del circulo con circunferencia $circunferencia  es : $radio")
//2. Desarrollar un algoritmo en scala que me diga si un numero es primo
var numero = Int : 0
if(numero !=2){
	if(numero%2){
		println(s"El numero $numero no es primo")
	}
}
else{
	println(s"El numero $numero es primo")
	
}
//3. Dada la variable bird = "tweet", utiliza interpolacion de string para imprimir "Estoy escribiendo un tweet"
val bird = "tweet"
val message = s"Estoy escribiendo un $bird"
println(message)

//4. Dada la variable mensaje = "Hola Luke yo soy tu padre!" utiliza slilce para extraer la
//   secuencia "Luke"
val mensaje = "Hola Luke, yo soy tu padre!"
mensaje slice(5,8)
//5. Cual es la diferencia en value y una variable en scala?
 var respuesta = "value (val) es un tipo de variable que una vez asignado su valor, este no puede cambiar y var, por el contrario, puede cambiar su valor, siempres y cuando este valor sea del mismo tipo que el original"
 println(respuesta)
//6. Dada la tupla ((2,4,5),(1,2,3),(3.1416,23) )) regresa el numero 3.1416 
val tup = ((2,4,5), (1,2,3),(3.1416,23))
tup._3._1