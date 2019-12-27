# 예제 2-14 스칼라로 빌드하고 실행하기

sbt clean package
$SPARK_HOME/bin/spark-submit \
  --class com.oreilly.learningsparkexamples.mini.scala.WordCount \
  ./target/...(위와 동일) \
  ./README.md ./wordcounts
