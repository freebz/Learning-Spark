// 예제 10-38 자바의 FlumeUtils 에이전트

JavaDStream<SparkFlumeEvent> events = FlumeUtils.createStream(ssc,
				      receiverHostname, receiverPort)
