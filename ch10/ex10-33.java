// 예제 10-33 자바에서 아파치 카프카로 팬더스 토픽을 받아 보기

import org.apache.spark.streaming.kafka.*;
...
// 토픽과 사용할 리시버 스레드 개수로 구성된 맵을 만든다
Map<String, Integer> topics = new HashMap<String, Integer>();
topics = new HashMap<String, Integer>();
topics.put("pandas", 1);
topics.put("logs", 1);
JavaPairDStream<String, String> topicLines =
  KafkaUtils.createStream(jssc, zkQuorum, group, topics);
topicLines.print();
