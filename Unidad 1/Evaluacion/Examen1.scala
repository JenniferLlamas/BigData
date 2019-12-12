//temporadas de Maria
val temp1_scores = List(10,5,20,20,4,5,2,25,1)
val temp2_scores = List(2,4,21,36,10,28,35,5,24,42)


//funcion BreakingRecord
//recibe una lista
//regresa un string

def BreakingRecords(temp_scores:List[Int]): String = {
  
  //asignación de primer registro de puntajes del primer juego realizado
  var score_max= temp_scores(0)
  var score_min= temp_scores(0)
  
  //contadores
  var cont_max =0
  var cont_min = 0
  
  
  for(score<-temp_scores){
    if(score>score_max){
      score_max=score
      cont_max=cont_max+1      
      //println(s"maximo= $puntaje_max contadorMAX =$cont_max")
    }
    
    if(score<score_min){
      score_min=score
      cont_min=cont_min+1   
      //println(s"minimo= $puntaje_min contadorMIN=$cont_min")
    }
  }
  
  return s" $cont_max $cont_min"
}

BreakingRecords(temp1_scores)
BreakingRecords(temp2_scores)
