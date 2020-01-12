// 예제 10-19 스칼라에서 IP 주소당 방문 횟수

val ipDStream = accessLogsDStream.map(logEntry => (logEntry.getIpAddress(), 1))
val ipCountDStream = ipDStream.reduceByKeyAndWindow(
  {(x, y) => x + y}, // 윈도에 들어가는 새로운 배치들의 값을 더한다
  {(x, y) => x - y}, // 윈도 범위에서 벗어나게 되는 가장 오래된 배치들의 값을 뺀다
  Seconds(30),       // 윈도 시간
  Seconds(10))       // 슬라이등 시간
