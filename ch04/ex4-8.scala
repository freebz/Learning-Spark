// 예제 4-8 스칼라에서 reduceByKey()와 mapValues()로 키별 평균 구하기

rdd.mapValues(x => (x, 1)).reduceByKey((x, y) => (x._1 + y._1, x._2 + y._2))
