// 예제 3-17 액션을 사용한 자바에서의 에러 세기

System.out.println("Input had " + badLinesRDD.count() + " concerning lines");
System.out.println("Here are 10 examples:");
for (String line: badLinesRDD.take(10)) {
  System.out.println(line);
}
