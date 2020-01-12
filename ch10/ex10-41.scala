// 예제 10-41 스칼라에서 Flumeutils로 사용자 싱크 사용

val events = FlumeUtils.createPollingStream(ssc, receiverHostname, receiverPort)
