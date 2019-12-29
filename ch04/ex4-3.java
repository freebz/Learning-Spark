// 예제 4-3 자바에서 첫 번째 단어를 키로 사용한 페어 RDD 생성

PairFunction<String, String, String> keyData =
  new PairFunction<String, String, String>() {
    public Tuple2<String, String> call(String x) {
      return new Tuple2(x.split(" ")[0], x);
    }
  };
JavaPairRDD<String, String> pairs = lines.mapToPair(keyData);
