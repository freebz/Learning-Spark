// 예제 3-27 스칼라에서 RDD의 값들을 제곱하기

val input = sc.parallelize(List(1, 2, 3, 4))
val result = input.map(x => x * x)
println(result.collect().mkString(","))
