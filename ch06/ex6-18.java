// 예제 6-18 자바에서 pipe()로 finddistance.R을 호출하는 드라이버 프로그램

// 외부 R 프로그램으로 각 콜의 거리를 계산하고
// 이 작업에서 각 노드가 다운로드받을 파일 리스트에 스크립트를 추가한다
String distScript = "./src/R/finddistance.R";
String distScriptName = "finddistance.R";
sc.addFile(distScript);
JavaRDD<String> pipeInputs = contactsContactLists.values()
  .map(new VerifyCallLogs()).flatMap(
  new FlatMapFunction<CallLog[], String>() {
    public Iterable<String> call(CallLog[] calls) {
      ArrayList<String> latLons = new ArrayList<String>();
      for (CallLog call: calls) {
	latLons.add(call.mylat + "," + call.mylong +
		    "," + call.contactlat + "," + call.contactlong);
      }
      return latLons;
    }
  });
JavaRDD<String> distances = pipeInputs.pipe(SparkFiles.get(distScriptName));
System.out.println(StringUtils.join(distances.collect(), ","));
