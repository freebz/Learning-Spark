// 예제 2-2 스칼라로 줄 수 세기

val lines = sc.textFile("README.md") // lines라는 RDD를 만든다.
// lines: spark.RDD[String] = MappedRDD[...]

lines.count() // 이 RDD의 아이템 개수를 센다
// res0: Long = 127

lines.first() // 이 RDD의 첫 번째 아이템, 이 예제에서는 README.me의 첫 번째 라인
// res1: String = # Apache Spark
