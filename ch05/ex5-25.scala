// 예제 5-25 스칼라에서 엘리펀트 버드로 LZO로 압축된 JSON 데이터 불러오기

val input = sc.newAPIHadoopFile(inputFile, classOf[LzoJsonInputFormat],
  classOf[LongWritable], classOf[MapWritable], conf)
// "input"에서 각 MapWritable은 JSON 객체로 표현된다
