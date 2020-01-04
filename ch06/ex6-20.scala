// 예제 6-20 스칼라에서 먼 거리의 로그 걸러 내기

// 이제 일부 잘못 보고된 위치일 가능성이 있는 먼 거리의 로그들은 걸러 낼 수 있다.
// 우선 문자열 RDD를 받아 double 형태로 바꾼다.
val distanceDoubles = distances.map(string => string.toDouble)
val stats = distanceDoubles.status()
val stddev = stats.stdev
val mean = stats.mean
val reasonableDistances = distanceDoubles.filter(x => math.abs(x-mean) < 3 * stddev)
println(reasonableDistances.collect().toList)
