def fib1(n:Int): Int = {
	if(n<2){
		return n
	}
	else{
		return fib1(n-1) + fib(n-2)
	}
}
/*Sucesion Fibonacci  con Matrices*/
def fib2(n:Int): Int = {
	if(n<2){
		return n
	}
	else{
		var i = ((1+math.sqrt(5))/2)
		var j= ((math.pow(i,n) - math.pow(((1-i),n))) / math.sqrt(5))
	}
	return j
	
}
/*Sucesion Fibonacci  iterativo*/
def fib3(n:Int): Int = {
	var a=0
	var b=1
	var c=0
	for(k<-n){
		c= b+a
		a=b
		b=c
	}
	return a
	
}
/*Sucesion Fibonacci  con dos variables*/
def fib4(n:Int): Int = {
	var a = 0
	var b= 1
	for(k<-n){
		b= b+a
		a= b-a
	}
	return a
	
}
/*Sucesion Fibonacci  con un vector*/
def fib5(n:Int): Int = {
	if(n<2){
		return n
	}
	else{
		var v = Array[Int](n+1)
		v._0 = 0
		v._1 = 1
		for(k<-2 ton n+1)
		{
			v._k = v._k-1 + v._k-2

		}
		return v._n
	}
}

/*Sucesion Fibonacci  con Matrices*/
def fib6(n:Int): Int = {
	if(n<=0){
		return 0
	}
	var i = n-1
	var auxOne = 0
	var auxTwo = 1

 	var  ab = Array[Int](auxTwo,auxOne)
	var  cd = Array[Int](auxOne,auxTwo)
	while(i>0){
		if(i%2 == 1){
			auxOne = ( ( cd(1) * ab(1) ) + ( cd(0) * ab(0) ) )
			auxTwo =( cd(1)* ( ab(1)+ ab(0) ) + cd(0)*ab(1) )
		}
		auxOne = (math.pow(cd(0),2)+ math.pow(cd(1),2)
		auxTwo = (cd(1)*(2*cd(0) + cd(1)))
		cd= (auxOne,auxTwo)
		i= i/2
	}
	return ab(0)+ab(1)

}
