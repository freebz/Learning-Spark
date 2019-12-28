// 예제 3-12 스칼라에서의 filter() 트랜스포메이션

val inputRDD = sc.textFile("log.txt")
val errorsRDD = inputRDD.filter(line => line.contains("error"))
