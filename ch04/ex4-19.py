# 예제 4-19 파이썬에서의 사용자 지정 정렬, 정수(integer)를 문자열인 것처럼 정렬하기

rdd.sortByKey(ascending=True, numPartitions=None, keyfunc = lambda x: str(x))
