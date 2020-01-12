// 예제 10-15 자바의 DStream에 transform() 사용

JavaPairDStream<String, Long> ipRawDStream = accessLogsDStream.transform(
  new Function<JavaRDD<ApacheAccessLong>, JavaRDD<ApacheAccessLong>>() {
    public JavaPairRDD<ApacheAccessLong> call(JavaRDD<ApacheAccessLong> rdd) {
      return extractOutliers(rdd);
    }
  });
