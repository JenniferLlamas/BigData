# BigData

# Proyecto Final

## Tabla de Contenido
<!-- AUTO-GENERATED-CONTENT:START (TOC:collapse=true&collapseText="Click to expand") -->
<details>
<summary>"Contenido"</summary>
  
- [Objetivo](#objetivo)
- [Introduccion](#introduccion)
- [Marco Teorico](#marco-teorico)
  * [Logistic Regression](#logistic-regresion)
  * [Decision Tree](#decision-tree)
  * [Linear Support Vector Machine](#linear-support-vector-machine)
- [Implementacion](#implementacion)
- [Conclusiones](#conclusiones)
- [Referencias](#referencias)

</details>
<!-- AUTO-GENERATED-CONTENT:END -->

## Objetivo

Comparación del rendimiento siguientes algoritmos de Machine Learning
- **Logistic Regresion** 
- **Decision Tree** 
- **Linear Support Vector Machine** 

Con el siguiente [Dataset](https://archive.ics.uci.edu/ml/datasets/Bank+Marketing) 

## Introduccion
El análisis de datos en la actualidad es un campo poco desarrollado dentro del área de sistemas, siendo que apenas se están creando carreras enfocadas a esta rama de la ingeniería, en la cual se utilizan algoritmos, supervisados o no supervisados, para realizar estimaciones para la toma de decisiones empresariales.
Sin embargo, a pesar de ser un área apenas en auge, su crecimiento es exponencial. Por lo que aprender a utilizar los algoritmos conllevaran a obtener los empleos del mañana o empezar a implementar esta área dentro de las empresas, como lo que es, una ingeniería en la cual se aplican los conocimientos de estadística y programación, ambos, en una sola persona, ya sea, un científico de datos, analista de datos, etc..

## Marco Teorico

### Logistic Regresion
El modelo logístico aplicado a los estudios de seguimiento fue introducido por Cornfield en el año 19623 y posteriormente aplicado al análisis de los datos del estudio de Framingham4. La adaptación al contexto de estudios causales planteaba el problema de la estimación de los coeficientes, por lo que el uso de ordenadores era imprescindible.[4]
La regresión logística, al igual que otras técnicas estadísticas multivariadas, da la posibilidad de evaluar la influencia de cada una de las variables independientes sobre la variable dependiente o de respuesta y controlar el efecto del resto. Tendremos, por tanto, una variable dependiente, llamémosla Y, que puede ser dicotómica o politómica y una o más variables independientes, llamémoslas X, que pueden ser de cualquier naturaleza, cualitativas o cuantitativas. Si la variable Y es dicotómica, podrá tomar el valor "0" si el hecho no ocurre y "1" si el hecho ocurre. Este proceso es denominado binomial ya que solo sólo tiene dos posibles resultados, siendo la probabilidad de cada uno de ellos constante en una serie de repeticiones.[3]
Un proceso binomial está caracterizado por la probabilidad de éxito, representada por p, la probabilidad de fracaso se representa por q. En ocasiones, se usa el cociente p/q que indica cuánto más probable es el éxito que el fracaso, como parámetro característico de la distribución binomial Los modelos de regresión logística son modelos de regresión que permiten estudiar si una variable categórica depende, o no, de otra u otras variables. La distribución condicional de la variable dependiente, al ser categórica, no puede distribuirse normalmente, toma la forma de una distribución binomial y, en consecuencia, la varianza no es constante, encontrándose situaciones de heterocedasticidad. El modelo de regresión logística puede ser representado de la siguiente manera:[3]

### `Figura 3` 

<p align="center">
  <img src="https://i.ytimg.com/vi/4h1vKWLIsNc/maxresdefault.jpg">
</p>

Donde: π1, es la probabilidad de observar la categoría o evento a predecir, y 1-π, es la probabilidad de no observar la categoría o evento a predecir. Es un modelo logístico lineal porque es lineal la escala del logaritmo de la razón de los productos cruzados (RPC). Varía entre -∞ y + ∞. Una ventaja de este modelo es que puede utilizarse en muestreos prospectivos o retrospectivos debido a que los efectos se refieren a la razón de los productos cruzados. Para una mejor compresión es conveniente recordar algunos conceptos.[3]

### Decision Tree

Un árbol de decisión es un modelo de predicción cuyo objetivo principal es el aprendizaje inductivo a partir de observaciones y construcciones lógicas. Son muy similares a los sistemas de predicción basados en reglas, que sirven para representar y categorizar una serie de condiciones que suceden de forma sucesiva para la solución de un problema. Constituyen probablemente el modelo de clasificación más utilizado y popular. El conocimiento obtenido durante el proceso de aprendizaje inductivo se representa mediante un árbol. Un árbol gráficamente se representa por un conjunto de nodos, hojas y ramas.[5]
El nodo principal o raíz es el atributo a partir del cual se inicia el proceso de clasificación; los nodos internos corresponden a cada una de las preguntas acerca del atributo en particular del problema. Cada posible respuesta a los cuestionamientos se representa mediante un nodo hijo. Las ramas que salen de cada uno de estos nodos se encuentran etiquetadas con los posibles valores del atributo. Los nodos finales o nodos hoja corresponden a una decisión, la cual coincide con una de las variables clase del problema a resolver (Ver Figura 1).[5]

### `Figura1` 
<p align="center">
<img align="center" src="http://student.mohammed.mx/tutoriales/analisis/541.gif">
</p>
Este modelo se construye a partir de la descripción narrativa de un problema, ya que provee una visión gráfica de la toma de decisión, especificando las variables que son evaluadas, las acciones que deben ser tomadas y el orden en el que la toma de decisión será efectuada. Cada vez que se ejecuta este tipo de modelo, sólo un camino será seguido dependiendo del valor actual de la variable evaluada. Los valores que pueden tomar las variables para este tipo de modelos pueden ser discretos o continuos.[5]

### Linear Support Vector Machine

Las máquinas de vectores de soporte (SVM, del inglés Support Vector Machine) tienen su origen en los trabajos sobre la teoría del aprendizaje estadístico y fueron introducidas en los años 90 por Vapnik y sus colaboradores Boser et al (1992); Cortes & Vapnik 1995.[1]
Dentro de la tarea de clasificación las SVM pertenecen a la categoría de los clasificadores lineales puesto que inducen separadores lineales, llamados hiperplanos. [1]
Mientras la mayoría de los métodos de aprendizaje se centran en minimizar los errores cometidos por el modelo generado a partir de los ejemplos de entrenamiento (error empírico) el sesgo inductivo asociado a las SVM radica en la minimización del denominado riesgo estructural. LA idea es seleccionar un hiperplano de separación que equidista de los ejemplos mas cercanos de cada clase, de esta forma, conseguir lo que se denomina un margen máximo a cada lado del hiperplano. [1]
Además, a la hora de definir el hiperplano, solo se consideran los ejemplos de entrenamiento de cada clase que caen justo en la frontera de dichos márgenes. Estos ejemplos reciben el nombre de vectores de soporte. [1]
El objetivo fundamental de este tipo de estudios es aprender a partir de los datos y para ello busca la existencia de alguna dependencia funcional entre un conjunto de vectores de entrada y valores de salida. [2]

Los modelos de vectores de soporte pueden ser utilizados en muchos problemas económicos donde se desea destacar la importancia de determinadas entradas. También si se trabaja con una gran cantidad de entradas, es útil tratar con los vectores de soporte ya que estos forman un esquema de compresión que permite reconstruir la solución del problema, en otras palabras, si consideramos exclusivamente los vectores de soporte y descartamos el resto de vectores de entrenamiento se tendría un problema de optimización con menos restricciones que proporciona la misma información.[2]

### `Figura 2` 
<p align="center">
  <img src="https://s3.amazonaws.com/quantstartmedia/images/qs-svm-0009.png">
</p>


## Implementacion

Los datos están relacionados con campañas de marketing directo de una institución bancaria portuguesa.
Las campañas de marketing se basaron en llamadas telefónicas. A menudo, se requería más de un contacto con el mismo cliente, para acceder si el producto (depósito bancario a plazo) estaría (o no) suscrito.

### Objetivo Implementacion del Dataset

El objetivo de clasificación es predecir si el cliente suscribirá un depósito a plazo (variable y).

## Herramientas

Para la realización de este análisis se utilizaron los lenguajes de programación Scala con el framework Spark.
Esto debido a la gran demanda que ha tenido este lenguaje de programación en los últimos años y la superación de performance de su contraparte en Python: Pandas, siendo scala diez veces mas potente en la ejecución de los algoritmos. Ademas de ser el lenguaje utilizado y aprendido en clase para aprender a analizar datos.


### Numero de Atributos

* Variables de entrada
   1. edad (numérico)
   2. trabajo: tipo de trabajo (categórico: "administrador", "desconocido", "desempleado", "gerencia", "empleada doméstica", "empresario", "estudiante", "trabajador", "trabajador independiente”, "retirado", "técnico", "servicios")
   3. marital: estado civil (categórico: "casado", "divorciado", "soltero"; nota: "divorciado" significa divorciado o viudo)
   4. educación (categórica: "desconocido", "secundario", "primario", "terciario")
   5. incumplimiento: ¿tiene crédito en incumplimiento? (binario: "sí", "no")
   6. saldo: saldo medio anual, en euros (numérico)
   7. vivienda: ¿tiene préstamo de vivienda? (binario: "sí", "no")
   8. préstamo: ¿tiene préstamo personal? (binario: "sí", "no")
   9. contacto: tipo de comunicación de contacto (categórico: "desconocido", "teléfono", "celular")
  10 días: último día de contacto del mes (numérico)
  11 meses: último contacto del año del año (categórico: "ene", "feb", "mar", ..., "nov", "dec")
  12. duración: duración del último contacto, en segundos (numérico)
  13. campaña: número de contactos realizados durante esta campaña y para este cliente (numérico, incluye el último contacto)
  14 días: número de días que pasaron después de que el cliente fue contactado por última vez desde una campaña anterior (numérico,.1 significa que el cliente no fue contactado previamente)
  15. anterior: número de contactos realizados antes de esta campaña y para este cliente (numérico)
  16. poutco1me: resultado de la campaña de marketing anterior (categórico: "desconocido", "otro", "fracaso", "éxito")

* Variable de salida (objetivo deseado):
  17. y. ¿el cliente ha suscrito un depósito a plazo? (binario: "sí", "no")


---

## Variables a considerar para el análisis del caso

* Variables de entrada:
   1. edad (numérico)
   2. trabajo: tipo de trabajo (categórico: "administrador", "desconocido", "desempleado", "gerencia", "empleada doméstica", "empresario", "estudiante", "trabajador", "trabajador independiente", "retirado", "técnico", "servicios")
   3.  marital: estado civil (categórico: "casado", "divorciado", "soltero")
   5.  incumplimiento: ¿tiene crédito en incumplimiento? (binario: "sí", "no")
   6.  saldo: saldo medio anual, en euros (numérico)
   7.  vivienda: ¿tiene préstamo de vivienda? (binario: "sí", "no")
   8.  préstamo: ¿tiene préstamo personal? (binario: "sí", "no")
  15.  anterior: número de contactos realizados antes de esta campaña y para este cliente (numérico)
  16.  poutcome: resultado de la campaña de marketing anterior (categórico: "desconocido", "otro", "fracaso", "éxito")

* Variable de salida (objetivo deseado):
  17.  y.  ¿el cliente ha suscrito un depósito a plazo? (binario: "sí", "no")


### Estructura de los datos a utilizar
* Age: Número
* Job: String
* Marital: String
* Default: Binary
* Balance: Número
* Housing: Binary
* Loan: Binary
* Previous: Número
* Poutcome: String

Para la utilizacion de los algoritmos se tienen que convertir los datos a tipo numerico. Esto se realizo con ayuda de la librería StringIndexer.


## Resultados
Los resultados de la ejecución de los algoritmos escogidos se muestran en la siguiente tabla

 Algoritmo | Precisión |
 ------------- | ------------- |
 Logistic Regresion | 89.2944 %  |
 Decision Tree  | 89.8603 %  |
 LSVM  | 88.8728 %  |

Si bien la primera corrida de SVM tardo mas tiempo en realizar el cálculo, la segunda vez que se ejecutó realizo el cálculo en un tiempo mucho menor que los otros dos algoritmos, aun cuando se le modifico el parámetro C de 0.1 a 1.

Se puede notar que los resultados mostrados por el algoritmo Decisión Tree son más precisos que los otros dos algoritmos por lo que para la toma de decisión sobre los datos obtenidos, se confía mas en lo que Decision Tree obtenga.


## Conclusiones

Para las variables tomadas para el desarrollo de este análisis, se puede concluir bajo los resultados de las precisiones, escoger el algoritmo de Decision Tree, ya que consume un menor tiempo de ejecución, y obtiene resultados más confiables.
Se puede notar que bajo las condicionales dadas, los tres algoritmos tienen una precisión que no varía más allá del 1 %.
El analista, en este caso, deberá de tener mas confianza en que el resultado dado por Decision Tree, y exponerlo al dueño del banco.	

## Referencias
1.	L. González Abril, Departamento de Economía aplicada I, Universidad de Sevilla. doi:http://www.cartagena99.com/recursos/alumnos/apuntes/Tema8._Maquinas_de_Vectores_Soporte.pdf
2.	BETANCOURT, G. (2005). LAS MÁQUINAS DE SOPORTE VECTORIAL (SVMs). Scientia et technica, 1(27). doi:http://dx.doi.org/10.22517/23447214.6895
3.	 Alderete, Ana, Universidad Nacional de Córdoba
doihttps://doi.org/10.35670/1667-4545.v6.n1.534
4.	O. Calvo, Manuel, Centro de Salud Pilas, Sevilla, Regresión logística no condicionada y tamaño de muestra: una revisión bibliográfica
Doi: https://www.scielosp.org/scielo.php?pid=S1135-57272002000200002&script=sci_arttext&tlng=pt
5.	Doi:https://www.medigraphic.com/pdfs/veracruzana/muv-2009/muv092c.pdf
