// 예제 10-32 스칼라에서 아파치 카프카로 팬더스 토픽을 받아 보기

import org.apache.spark.streaming.kafka._
...
// 토픽과 사용할 리시버 스레드 개수로 구성된 맵을 만든다
val topics = List(("pandas", 1), ("logs", 1)).toMap
val topicLines = KafkaUtils.createStream(ssc, zkQuorum, group, topics)
topicLines.print()
