// 예제 3-23 자바에서 이름 있는 클래스로 함수 전달하기

class ContainsError implements Function<String, Boolean>() {
  public Boolean call(String x) { return x.contains("error"); }
}

RDD<String> errors = lines.filter(new ContainsError());
