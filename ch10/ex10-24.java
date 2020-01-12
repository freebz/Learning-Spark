// 예제 10-24 자바에서 updateStateByKey()를 사용하여 응답 코드를 실행 중에 집계하기

class UpdateRunningSum implements Function2<List<Long>,
    Optional<Long>, Optional<Long>> {
  public Optional<Long> call(List<Long> nums, Optional<Long> current) {
    long sum = current.or(0L);
    return Optional.of(sum + nums.size());
  }
};

JavaPairDStream<Integer, Long> responseCodeCountDStream = accessLogsDStream.mapToPair(
    new PairFunction<ApacheAccessLog, Integer, Long>() {
      public Tuple2<Integer, Long> call(ApacheAccessLog log) {
	return new Tuple2(log.getResponseCode(), 1L);
      }})
  .updateStateByKey(new UpdateRunningSum());
