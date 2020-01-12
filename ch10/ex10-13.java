// 예제 10-13 자바에서 두 DStream 조인

JavaPairDStream<String, Long> ipBytesDStream =
  accessLogsDStream.mapToPair(new IpContentTyple());
JavaPairDStream<String, Long> ipBytesSumDStream =
  ipBytesDStream.reduceByKey(new LongSumReducer());
JavaPairDStream<String, Tuple2<Long, Long>> ipBytesRequestCountDStream =
  ipCountsDStream.join(ipBytesSumDStream);
