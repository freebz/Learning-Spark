// 예제 6-9 자바에서 브로드캐스트 변수를 쓴 국가 검색

// 콜사인 표를 읽어 들인 후 contactCounts RDD에서
// 각 콜 사인에 대한 국가를 검색한다.
final Broadcast<String[]> signPrefixes = sc.broadcast(loadCallSignTable());
JavaPairRDD<String, Integer> countryContactCounts = contactCounts.mapToPair(
  new PairFunction<Tuple2<String, Integer>, String, Integer> (){
    public Tuple2<String, Integer> call(Tuple2<String, Integer> callsSignCount) {
      String sign = callsSignCount._1();
      String country = lookupCountry(sign, callSignInfo.value());
      return new Tuple2(country, callsSignCount._2());
    }}).reduceByKey(new SumInts());
countryContactCounts.saveAsTextFile(outputDir + "/countries.txt");
