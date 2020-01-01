// 예제 5-23 스칼라에서 시퀀스 파일로 저장하기

val data =sc.parallelize(List(("Panda", 3), ("Kay", 6), ("Snail", 2)))
data.saveAsSequenceFile(outputFile)
