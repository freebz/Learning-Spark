// 예제 5-4 스칼라로 파일별 평균값 구하기

val input = sc.wholeTextFiles("file:///home/holden/salesFiles")
val result = input.mapValues{y =>
  val nums = y.split(" ").map(x => x.toDouble)
  nums.sum / nums.size.toDouble
}
