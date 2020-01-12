// 예제 10-20 자바에서 IP 주소당 방문 횟수

class ExtractIp extends PairFunction<ApacheAccessLog, String, Long> {
  public Tuple2<String, Long> call(ApacheAccessLog entry) {
    return new Tuple2(entry.getIpAddress(), 1L);
  }
}
class AddLongs extends Function2<Long, Long, Long>() {
  public Long call(Long v1, Long v2) { return v1 + v2; }
}
class SubtractLongs extends Function2<Long, Long, Long>() {
  public Long call(Long v1, Long v2) { return v1 - v2; }
}

JavaPairDStream<String, Long> ipAddressPairDStream = accessLogsDStream.mapToPair(
  new ExtractIp());
JavaPairDStream<String, Long> ipCountDStream = ipAddressPairDStream.
  reduceByKeyAndWindow(
    new AddLongs(), // 윈도에 들어가는 새로운 배치들의 값을 더한다
    new SubtractLongs(), // 윈도 범위에서 벗어나게 되는 가장 오래된 배치들의 값을 뺀다
    Durations.seconds(30), // 윈도 시간
    Durations.seconds(10)); // 슬라이딩 시간
