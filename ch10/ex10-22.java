// 예제 10-22 자바에서 윈도 집계 연산

JavaDStream<String> ip = accessLogsDStream.map(
  new Function<ApacheAccessLog, String>() {
    public String call(ApacheAccessLog entry) {
      return entry.getIpAddress();
    }});
JavaDStream<Long> requestCount = accessLogsDStream.countByWindow(
  Durations.seconds(30), Durations.seconds(10));
JavaPairDStream<String, Long> ipAddressRequestCount = ip.countByValueAndWindow(
  Durations.seconds(30), Durations.seconds(10));
