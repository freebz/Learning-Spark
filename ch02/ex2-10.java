// 예제 2-10 단어 세기 자바 애플리케이션 - 아직 세부적인 코드 내용에는 신경 쓰지 않아도 된다

// 자바 SparkContext 객체를 만듦
SparkConf conf = new SparkConf().setAppName("wordCount");
JavaSparkContext sc = new JavaSparkContext(conf);
// 입력 데이터를 불러온다.
JavaRDD<String> input = sc.textFile(inputFile);
// 단어별로 나눈다.
JavaRDD<String> words = input.flatMap(
  new FlatMapFunction<String, String>() {
    public Iterable<String> call(String x) {
      return Arrays.asList(x.split(" "));
    }});
// 단어, 숫자 쌍으로 변환하고 개수를 센다.
JavaPairRDD<String, Integer> counts = words.mapToPair(
  new PairFunction<String, String, Integer>(){
    public Tuple2<String, Integer> call(String x){
      return new Tuple2(x, 1);
    }}).reduceByKey(new Function2<Integer, Integer, Integer>(){
	public Integer call(Integer x, Integer y){ return x + y;}});
// 단어 개수를 다시 텍스트 파일로 저장한다.
counts.saveAsTextFile(outputFile);
