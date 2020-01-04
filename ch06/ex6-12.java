// 예제 6-12 자바에서 접속 풀과 JSON 파서 공유

// 셋업 작업을 재사용하기 위해 mapPartitions 사용
JavaPairRDD<String, CallLog[]> contactsContactLists =
  validCallSigns.mapPartitionsToPair(
  new PairFlatMapFunction<Iterator<String>, String, CallLog[]>() {
    public Iterable<Tuple2<String, CallLog[]>> call(Iterator<String> input) {
      // 최종 결과 리스트
      ArrayList<Tuple2<String, CallLog[]>> callsignLogs = new ArrayList<>();
      ArrayList<Tuple2<String, ContentExchange>> requests = new ArrayList<>();
      ObjectMapper mapper = createMapper();
      HttpClient client = new HttpClient();
      try {
	client.start();
	while (input.hadNext()) {
	  requests.add(createRequestForSign(input.next(), client));
	}
	for (Tuple2<String, ContentExchange> signExchange : requests) {
	  callsignLogs.add(fetchResultFromRequest(mapper, signExchange));
	}
      } catch (Exception e) {
      }
      return callsignLogs;
    }});
System.out.println(StringUtils.join(contactsContactLists.collect(), ","));
