// 예제 10-46 자바에서 장애 복구가 가능하도록 드라이버 세팅하기

JavaStreamingContextFactory fact = new JavaStreamingContextFactory() {
  public JavaStreamingContext call() {
    ...
    JavaSparkContext sc = new JavaSparkContext(conf);
    // StreamingContext를 1초의 배치 크기로 생성한다
    JavaStreamingContext jssc = new JavaStreamingContext(sc, Durations.seconds(1));
    jssc.checkpoint(checkpointDir);
    return jssc;
  }};
JavaStreamingContext jssc = JavaStreamingContext.getOrCreate(checkpointDir, fact);
