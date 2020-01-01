// 예제 5-22 자바에서 시퀀스 파일 불러오기

public static class ConvertToNativeTypes implements
  PairFunction<Tuple2<Text, IntWritable>, String, Intger> {
  public Tuple2<String, Integer> call(Tuple2<Text, IntWritable> record) {
    return new Tuple2(record._1.toString(), record._2.get());
  }
}

JavaPairRDD<Text, IntWriable> input = sc.sequenceFile(fileName, Text.class,
  IntWriable.class);
JavaPairRDD<String, Integer> result = input.mapToPair(
  new ConvertToNativeTypes());
