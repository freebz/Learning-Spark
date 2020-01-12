// 예제 10-34 스칼라에서 아파치 카프카로 팬더스 토픽 직접 읽기

import org.apache.spark.streaming.kafka._
import kafka.serializer.StringDecoder
...
// kafkaParams에 브로커들을 지정해 준다
val kafkaParams = Map[String, String]("metadata.broker.list" -> brokers)
// 토픽과 사용할 리시버 스레드 개수로 구성도니 맵을 만든다
val topicSet = List("pandas", "logs").toSet
val topicLines = KafkaUtils.createDirectStream[String, String,
   StringDecoder, StringDecoder](ssc, kafkaParams, topicSet)
StreamingLogInput.processLines(topicLines.map(_._2))
