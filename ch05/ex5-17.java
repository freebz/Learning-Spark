// 예제 5-17 자바에서 전체적으로 CSV 불러오기

public static class ParseLine
  implements FlatMapFunction<Tuple2<String, String>, String[]> {
  public Iterable<String[]> call(Tuple2<String, String> file) throws Exception {
    CSVReader reader = new CSVReader(new StringReader(file._2()));
    return reader.readAll();
  }
}
JavaPairRDD<String, String> csvData = sc.wholeTextFiles(inputFile);
JavaRDD<String[]> keyedRDD = csvData.flatMap(new ParseLine());
