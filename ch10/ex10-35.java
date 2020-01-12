// 예제 10-35 자바에서 아파치 카프카로 팬더스 토픽 직접 읽기

import org.apache.spark.streaming.kafka.*;
import kafka.serializer.StringDecoder;
...
HashSet<String> topicSet = new HashSet<String>();
topicSet.put("pandas");
topicSet.put("logs");
HashMap<String, String> kafkaParams = new HashMap<String, String>();
kafkaParams.put("metadata.broker.list", brokers);
JavaPairDStream<String, String> input =
  KafkaUtils.createDirectStream(jssc,
    String.class,
    String.class,
    StringDecoder.class,
    StringDecoder.class,
    kafkaParams,
    topics);
input.print();
