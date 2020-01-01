// 예제 5-21 스칼라에서 시퀀스 파일 불러오기

val data = sc.sequenceFile(inFile, classOf[Text], classOf[IntWritable]).
map{case (x, y) => (x.toString, y.get())}
