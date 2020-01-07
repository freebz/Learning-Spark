# 예제 8-4 플래그를 사용하여 실행 시의 설정값 지정

bin/spark-submit \
  --class com.example.MyApp \
  --master local[4] \
  --name "My Spark App" \
  --conf spark.ui.port=36000 \
  myApp.jar
