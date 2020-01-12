// 예제 10-5 자바에서 "error"를 포함하는 라인만을 출력하기 위한 스트리밍 필터

// SparkConf로부터 1초의 배치 간격으로 StreamingContext를 생성한다
JavaStreamingContext jssc = new JavaStreamingContext(conf, Durations.seconds(1));
// 7777 포트로 오는 모든 입력으로부터 DStream을 생성한다
JavaDStream<String> lines = jssc.socketTextStream("localhost", 7777);
// "error"를 포함한 라인만 걸러 내어 DStream을 만든다
JavaDStream<String> errorLines = lines.filter(new Function<String, Boolean>() {
  public Boolean call(String line) {
    return line.contains("error");
  }});
// 에러 라인들을 출력한다
errorLines.print();
