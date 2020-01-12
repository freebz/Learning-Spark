// 예제 10-27 자바에서 DStream을 시퀀스 파일로 저장하기

JavaPairDStream<Text, LongWritable> wriableDStream = ipDStream.mapToPair(
  new PairFunction<Tuple2<String, Long>, Text, LongWritable>() {
    public Tuple2<Text, LongWritable> call(Tuple2<String, Long> e) {
      return new Tuple2(new Text(e._1()), new LongWritable(e._2()));
  }});
class OutFormat extends SequenceFileOutputFormat<Text, LongWritable> {};
writableDStream.saveAsHadoopFiles(
  "outputDir", "txt", Text.class, LongWritable.class, OutFormat.class);
