// 예제 5-47 스칼라에서 일래스틱서치 입력

def mapWritableToInput(in: MapWritable): Map[String, String] = {
  in.map{case (k, v) => (k.toString, v.toString)}.toMap
}

val jobConf = new JobConf(sc.hadoopConfiguration)
jobConf.set(ConfigurationOptions.ES_RESOURCE_READ, args(1))
jobConf.set(ConfigurationOptions.ES_NODES, args(2))
val currentTweets = sc.hadoopRDD(jobConf,
  classOf[EsInputFormat[Object, MapWritable]], classOf[Object],
  classOf[MapWritable])
// 맵만 추출한다
// MapWritable[Text, Text]를 Map[String, String]으로 변환한다
val tweets = currentTweets.map{ case (key, value) => mapWritableToInput(value) }
