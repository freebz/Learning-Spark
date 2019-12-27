// 예제 2-5 스칼라 필터링 예제

val lines = sc.textFile("README.md") // lines라는 이름의 RDD를 생성한다
// lines: spark.RDD[String] = MappedRDD[...]

val pythonLines = lines.filter(line => line.contains("Python"))
// pythonLines: spark.RDD[String] = FilteredRDD[...]

pythonLines.first()
// res0: String = ## Interactive Python Shell
