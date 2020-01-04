// 예제 6-8 스칼라에서 브로드캐스트 변수를 쓴 국가 검색

# RDD의 contactCounts에서 콜 사인의 위치를 검색한다.
# 이 검색 작업을 위해 각 국가 코드의 콜 사인 접두어
# 리스트를 불러온다.
val signPrefixes = sc.broadcast(loadCallSignTable())
val countryContactCounts = contactCounts.map{case (sign, count) =>
  val country = lookupInArray(sign, signPrefixes.value)
  (country, count)
}.reduceByKey((x, y) => x + y)
countryContactCounts.saveAsTextFile(outputDir + "/countries.txt")
