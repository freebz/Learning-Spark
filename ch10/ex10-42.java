// 예제 10-42 자바에서 FlumeUtils로 사용자 싱크 사용

JavaDStream<SparkFlumeEvent> events = FlumeUtils.createPollingStream(ssc,
    receiverHostname, receiverPort)
