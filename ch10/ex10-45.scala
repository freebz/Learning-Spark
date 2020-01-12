// 예제 10-45 스칼라에서 장애 복구가 가능하도록 드라이버 세팅하기

def createStreamingContext() = {
  ...
  val sc = new SparkContext(conf)
  // StreamingContext를 1초의 배치 크기로 생성한다
  val ssc = new StreamingContext(sc, Seconds(1))
  ssc.checkpoint(checkpointDir)
}
...
val ssc = StreamingContext.getOrCreate(checkpointDir, createStreamingContext _)
