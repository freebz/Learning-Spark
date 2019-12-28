// 예제 3-30 여러 라인을 단어로 분해하는 스칼라의 flatMap()

val lines = sc.parallelize(List("hello world", "hi"))
val words = lines.flatMap(line => line.split(" "))
words.first() // "hello"를 반환
