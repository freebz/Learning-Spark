// 예제 10-12 스칼라에서 두 DStream 조인

val ipBytesDStream =
  accessLogsDStream.map(entry => (entry.getIpAddress(), entry.getContentSize()))
val ipBytesSumDStream =
  ipBytesDStream.reduceByKey((x, y) => x + y)
val ipBytesRequestCountDStream =
  ipCountsDStream.join(ipBytesSumDStream)
