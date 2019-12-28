// 예제 3-25 자바 8의 람다 표현식을 사용한 함수 전달

RDD<String> errors = lines.filter(s -> s.contains("error"));
