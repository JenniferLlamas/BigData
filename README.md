# BigData
Unidad 2 -Classification Algoritms

## Basic Stadistics
### Correlation
Correlation computes the correlation matrix for the input Dataset of Vectors using the specified method. The output will be a DataFrame that contains the correlation matrix of the column of vectors.

### Library
```scala
import org.apache.spark.ml.linalg.{Matrix, Vectors}
import org.apache.spark.ml.stat.Correlation
import org.apache.spark.sql.Row
```
### Hipothesis Testing
Hypothesis testing is a powerful tool in statistics to determine whether a result is statistically significant, whether this result occurred by chance or not. spark.ml currently supports Pearson’s Chi-squared ( χ2) tests for independence.

### Libraries
```scala
import org.apache.spark.ml.linalg.{Vector, Vectors}
import org.apache.spark.ml.stat.ChiSquareTest
```
### Summarizer
vector column summary statistics for Dataframe through Summarizer. Available metrics are the column-wise max, min, mean, variance, and number of nonzeros, as well as the total count.

### Library
```scala
import org.apache.spark.ml.stat.Summarizer
```
## Logistic regression
Logistic regression is a popular method to predict a categorical response.  
Logistic regression can be used to predict a binary outcome by using binomial logistic regression, or it can be used to predict a multiclass outcome by using multinomial logistic regression.

### Library
```scala
import org.apache.spark.ml.classification.LogisticRegression
```

## Decision tree classifier
Decision Tree Classifier is a simple and widely used classification technique. It applies a straitforward idea to solve the classification problem. Decision Tree Classifier poses a series of carefully crafted questions about the attributes of the test record. Each time time it receive an answer, a follow-up question is asked until a conclusion about the calss label of the record is reached.

### Libraries
```scala
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.DecisionTreeClassificationModel
import org.apache.spark.ml.classification.DecisionTreeClassifier
```
## Random forest classifier
Random forest classifier creates a set of decision trees from randomly selected subset of training set. It then aggregates the votes from different decision trees to decide the final class of the test object.

### Libraries
```scala
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.{RandomForestClassificationModel, RandomForestClassifier}
```
## Gradient-boosted tree classifier
A gradient boosted model is an ensemble of either regression or classification tree models. Both are forward-learning ensemble methods that obtain predictive results through gradually improved estimations. Boosting is a flexible nonlinear regression procedure that helps improving the accuracy of trees. By sequentially applying weak classification algorithms to the incrementally changed data, a series of decision trees are created that produce an ensemble of weak prediction models. While boosting trees increases their accuracy, it also decreases speed and human interpretability. The gradient boosting method generalizes tree boosting to minimize these issues.

### Libraries
```scala
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.{GBTClassificationModel, GBTClassifier}
```
## Multilayer perceptron classifier
Multilayer perceptron classifier (MLPC) is a classifier based on the feedforward artificial neural network. MLPC consists of multiple layers of nodes. Each layer is fully connected to the next layer in the network. Nodes in the input layer represent the input data. All other nodes map inputs to outputs by a linear combination of the inputs with the node’s weights w and bias b and applying an activation function

### Library
```scala
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
```
## Linear Support Vector Machine
A support vector machine constructs a hyperplane or set of hyperplanes in a high- or infinite-dimensional space, which can be used for classification, regression, or other tasks. Intuitively, a good separation is achieved by the hyperplane that has the largest distance to the nearest training-data points of any class (so-called functional margin), since in general the larger the margin the lower the generalization error of the classifier.

### Library
```scala
import org.apache.spark.ml.classification.LinearSVC
```
## One-vs-Rest classifier (a.k.a. One-vs-All)
OneVsRest is an example of a machine learning reduction for performing multiclass classification given a base classifier that can perform binary classification efficiently. It is also known as “One-vs-All.”

OneVsRest is implemented as an Estimator. For the base classifier, it takes instances of Classifier and creates a binary classification problem for each of the k classes. The classifier for class i is trained to predict whether the label is i or not, distinguishing class i from all other classes.

### Library
```scala
import org.apache.spark.ml.classification.{LogisticRegression, OneVsRest}
```

## Naive Bayes
Naive Bayes classifiers are a family of simple probabilistic, multiclass classifiers based on applying Bayes’ theorem with strong (naive) independence assumptions between every pair of features.

Naive Bayes can be trained very efficiently. With a single pass over the training data, it computes the conditional probability distribution of each feature given each label. For prediction, it applies Bayes’ theorem to compute the conditional probability distribution of each label given an observation.

### Library
```scala
import org.apache.spark.ml.classification.NaiveBayes
```

## Spark Documentation
For more details visit the oficial [Apache Spark Documentation](https://spark.apache.org/docs/latest/ml-classification-regression.html)
