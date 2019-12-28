// 예제 3-39 스칼라에서의 반복 사용

val result = input.map(x => x*x)
println(result.count())
println(result.collect().mkString(","))
