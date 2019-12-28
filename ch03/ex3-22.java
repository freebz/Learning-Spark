// 예제 3-22 자바에서 익명 내부 클래스로 함수 전달하기

RDD<String> errors = lines.filter(new Function<String, Boolean>() {
  public Boolean call(String x) { return x.contains("error"); }
});
