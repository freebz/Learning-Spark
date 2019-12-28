// 예제 3-16 액션을 사용한 스칼라에서의 에러 세기

println("Input had " + badLinesRDD.count() + " concerning lines")
println("Here are 10 examples:")
badLinesRDD.take(10).foreach(println)
