// 예제 10-11 자바에서 DStream에 map()과 reduceByKey() 사용

// ApacheAccessLog는 아파치 로그로부터 각 엔트리를 파싱하는 유틸리티 클래스라고 가정
static final class IpTuple implements PairFunction<ApacheAccessLog, String, Long> {
  public Tuple2<String, Long> call(ApacheAccessLog log) {
    return new Tuple2<>(log.getIpAddress(), 1L);
  }
}

JavaDStream<ApacheAccessLog> accessLogsDStream =
  logData.map(new ParseFromLogLine());
JavaPairDStream<String, Long> ipDStream =
  accessLogsDStream.mapToPair(new IpTutpe());
JavaPairDStream<String, Long> ipCountsDStream =
  ipDStream.reduceByKey(new LongSumReducer());
