// 예제 4-20 스칼라에서의 사용자 지정 정렬, 정수를 문자열인 것처럼 정렬하기

val input: RDD[(Int, Venue)] = ...
implicit val sortIntegerByString = new Ordering[Int] {
  override def compare(a: Int, b: Int) = a.toString.compare(b.toString)
}
rdd.sortByKey(sortIntegerByString)
