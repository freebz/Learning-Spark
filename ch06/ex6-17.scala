// 예제 6-17 스칼라에서 pipe()로 finddistance.R을 호출하는 드라이버 프로그램

// 외부 R 프로그램으로 각 콜의 거리를 계산하고
// 이 작업에서 각 노드가 다운받을 파일 리스트에 스크립트를 추가한다
val distScript = "./src/R/finddistance.R"
val distScriptName = "finddistance.R"
sc.addFile(distScript)
val distances = contactsContactLists.values.flatMap(x => x.map(y =>
  s"$y.contactlat,$y.contactlong,$y.mylat,$y.mylong")).pipe(Seq(
    SparkFiles.get(distScriptName)))
println(distances.collect().toList)
