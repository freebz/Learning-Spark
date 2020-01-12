// 예제 10-10 스칼라에서 DStream에 map()과 reduceByKey() 사용

// ApacheAccessLog는 아파치 로그로부터 각 엔트리를 파싱하는 유틸리티 클래스라고 가정
val accessLogsDStream = logData.map(line => ApacheAccessLog.parseFromLogLine(line))
val ipDStream = accessLogsDStream.map(entry => (entry.getIpAddress(), 1))
val ipCountsDStream = ipDStream.reduceByKey((x, y) => x + y)
