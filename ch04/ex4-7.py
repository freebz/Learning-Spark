# 예제 4-7 파이썬에서 reduceByKey()와 mapValues()로 키별 평균 구하기

rdd.mapValues(lambda x: (x, 1)).reduceByKey(lambda x, y: (x[0] + y[0], x[1] + y[1]))
