// 예제 5-24 스칼라에서 구버전 API로 KeyValueTextInputFormat() 불러오기

val input = sc.hadoopFile[Text, Text, KeyValueTextInputFormat](inputFile).map{
  case (x, y) => (x.toString, y.toString)
}
