// 예제 4-16 스칼라에서 병렬화 직접 지정을 사용한 reduceByKey()

val data = Seq(("a", 3), ("b", 4), ("a", 1))
sc.parallelize(data).reduceByKey((x, y) => x + y)     // 기본 병렬화 수준 사용
sc.parallelize(data).reduceByKey((x, y) => x + y, 10) // 병렬화 수준 지정
