# 예제 8-5 기본값 파일을 사용한 실행 시의 설정값 지정

bin/spark-submit \
  --class com.example.MyApp \
  --properties-file my-config.conf \
myApp.jar


## my-config.conf의 내용 ##
spark.master   local[4]
spark.app.name "My Spark App"
spark.ui.port  36000
