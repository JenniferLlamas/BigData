import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header", "true").option("inferSchema","true")csv("Sales.csv")

df.count
df.select(first($"Volume")).show()
df.select($"Low")
df.select(max($"High")).show()
df.select(max($"Min")).show()
df.select(avg($"Min")).show()
df.select(sum($"Min")).show()
df.select(sumDistinct($"Min")).show()
df.select(variance($"Volume")).show()
df.select(kurtosis($"Volume")).show()
df.select(skewness($"Volume")).show()
df.select(mean($"Volume")).show()
df.select(var_pop($"Low")).show()
df.select(var_samp($"Low")).show()
df.select(stddev_samp($"Low")).show()
df.select(current_date()).show()
df.select(year($"Date")).show()
df.select(col("Low")).show()
df.select(stddev($"Low")).show()
df.select(current_timestamp()).show()