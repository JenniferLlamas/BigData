//sesion de spark
import org.apache.spark.sql.Row
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()

// Lectura del archivo csv
val data = spark.read.option("header", true).option("inferSchema", "true").option("delimiter", ";").csv("bank.csv")

//visualizacion del esquema del dataframe
data.printSchema
//visualizacion de algunos datos del dataframe
data.show(5)

//seleccion de columnas a utilizar
val data_toWork = data.select("age","job","marital","default","balance","housing","loan","previous","poutcome","y")

//visualizacion de los datos seleccionados (solo 5, esto para ver la tabla)
data_toWork.show(5)


//creacion de etiqueta label a partir de la columna y, que representa la decision del algoritmo
//1 -- yes
//0 -- no
// se guarda como df2
val df2 = data_toWork.withColumn("label", when(col("y") === "yes", 1).otherwise(0))


//-----------conversion de los datos categoricos a un valor numerico para su analisis----------
//libreria a utilizar StringIndexer : Convierte datos String a Numericos 
import org.apache.spark.ml.feature.{StringIndexer,IndexToString,VectorIndexer}

//uso de StringIndexer para la creacion de los datos numericos
val indexerJob = new StringIndexer().setInputCol("job").setOutputCol("D_Job").fit(df2).transform(df2)
val indexerMarital = new StringIndexer().setInputCol("marital").setOutputCol("D_Marital").fit(indexerJob).transform(indexerJob)
val indexerDefault = new StringIndexer().setInputCol("default").setOutputCol("D_Default").fit(indexerMarital).transform(indexerMarital)
val indexerHousing = new StringIndexer().setInputCol("housing").setOutputCol("D_Housing").fit(indexerDefault).transform(indexerDefault)
val indexerLoan = new StringIndexer().setInputCol("loan").setOutputCol("D_Loan").fit(indexerHousing).transform(indexerHousing)
val indexerPrevious = new StringIndexer().setInputCol("previous").setOutputCol("D_Previous").fit(indexerLoan).transform(indexerLoan)
val indexerPoutcome = new StringIndexer().setInputCol("poutcome").setOutputCol("D_Poutcome").fit(indexerPrevious).transform(indexerPrevious)


//nuevo dataframe con las columas indexadas
val df3 = indexerPoutcome.select("age","D_Job","D_Marital","D_Default","balance","D_Housing","D_Loan","previous","D_Poutcome","label")
df3.show(5)

//uso de VectorAssembler para construir vector con los campos a analizar
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors

//creacion del vector con las columnas transformadas
//columnas a añadir al vector
val features = Array("age","D_Job","D_Marital","D_Default","balance","D_Housing","D_Loan","previous","D_Poutcome")

//construccion de vector
val assembler = new VectorAssembler().setInputCols(features).setOutputCol("features")

//transformacion de los datos finales
val finaldata = assembler.transform(df3)
finaldata.show(5)


//variable que almacene solo las columnas que se necesitan: label y features
val toAnalizeData = finaldata.select("label","features")


//visualizacion de los datos formateados
toAnalizeData.show(5)
//-------------------Analisis de los datos con Algoritmos de Maching Learning ---------------------

//---------------------------Regresion Logistica---------------------------
import org.apache.spark.ml.classification.LogisticRegression

val Array(training, test) = toAnalizeData.randomSplit(Array(0.7, 0.3), seed = 12345)

val lr = new LogisticRegression()

val model = lr.fit(toAnalizeData)

println(s"Coeficientes: \n${model.coefficientMatrix}")
println(s"Intercepcion: \n${model.interceptVector}")

val trainingSummary = model.summary
val accuracyLR = trainingSummary.accuracy
println(s"Precision: $accuracyLR\n")


//--------------------------Decision Tree-------------------------------

//librerias a utilizar
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.DecisionTreeClassificationModel
import org.apache.spark.ml.classification.DecisionTreeClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator

val labelIndexer = new StringIndexer().setInputCol("label").setOutputCol("indexedLabel").fit(toAnalizeData)
val featureIndexer = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4).fit(toAnalizeData)

val dt = new DecisionTreeClassifier().setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures")

val labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(labelIndexer.labels)
val pipeline = new Pipeline().setStages(Array(labelIndexer, featureIndexer, dt, labelConverter))

val predictions = model.transform(testData)
predictions.show(5)

//predictions.select("predictedLabel", "label", "features").show(5)

val evaluator = new MulticlassClassificationEvaluator().setLabelCol("label").setPredictionCol("prediction").setMetricName("accuracy")
val accuracyDT = evaluator.evaluate(predictions)
println(s"Precision: $accuracyDT")


//-----------------------------------------SVM--------------------------------------------
import org.apache.spark.ml.classification.LinearSVC
import org.apache.spark.ml.classification.{LogisticRegression, OneVsRest}


val lsvc = new LinearSVC().setMaxIter(10).setRegParam(0.1)

val lsvcModel = lsvc.fit(training)

val ovr = new OneVsRest().setClassifier(lsvc)
val ovrModel = ovr.fit(test)
val predictionsSVM = ovrModel.transform(test)
println(s"Coeficientes: ${lsvcModel.coefficients} Intercepciones: ${lsvcModel.intercept}")

val evaluatorSVM = new MulticlassClassificationEvaluator().setMetricName("accuracy")

val accuracySVM = evaluatorSVM.evaluate(predictionsSVM)
//------------------------------------------Results -----------------------------------------
println("--------------- Resultados -----------------------")
val results = (accuracyLR*100,accuracyDT*100,accuracySVM*100)
println(results)
println("F I N A L      B A A A A M M M !")
