# 예제 10-8 스트리밍 앱 실행과 리눅스/맥에서 데이터 입력

spark-submit --class com.oreilly.learningsparkexamples.scala.StreamingLogInput \
$ASSEMBLY_JAR local[4]

nc localhost 7777 # 서버에 보낼 수 있도록 직접 타이핑해서 입력하게 해 준다
<여기에 입력>
