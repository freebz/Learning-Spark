// 예제 10-4 스칼라에서 "error"를 포함하는 라인만을 출력하기 위한 스트리밍 필터

// SparkConf로부터 1초의 배치 간격으로 StreamingContext를 생성한다
val ssc = new StreamingContext(conf, Seconds(1))
// 로컬 머신의 7777 포트에 연결한 후 데이터를 받도록 DStream을 생성한다
val lines = ssc.socketTextStream("localhost", 7777)
// "error"를 포함한 라인만 걸러 내어 DStream을 만든다
val errorLines = lines.filter(_.contains("error"))
// 에러 라인들을 출력한다
errorLines.print()
