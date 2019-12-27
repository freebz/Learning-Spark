// 예제 2-11 단어 세기 스칼라 애플리케이션 - 아직 세부적인 코드 내용에는 신경 쓰지 않아도 된다

// 스칼라 SparkContext 객체를 만듦
val conf = new SparkConf().setAppName("wordCount")
val sc = new SparkContext(conf)
// 입력 데이터를 불러온다.
val input sc.textFile(inputFile)
// 단어별로 나눈다.
val words = input.flatMap(line => line.split(" "))
// 단어, 숫자 쌍으로 변환하고 개수를 센다.
val counts = words.map(word => (word, 1)).reduceByKey{case (x, y) => x + y}
// 단어 개수를 다시 텍스트 파일로 저장한다.
counts.saveAsTextFile(outputFile)
