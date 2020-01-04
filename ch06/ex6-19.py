# 예제 6-19 파이썬에서 먼 거리의 로그 걸러 내기

# 문자열 RDD를 수치 데이터로 변환하여 통계를 계산하고
# 거리가 먼 데이터를 걸러 낸다.
distanceNumerics = distances.map(lambda string: float(string))
stats = distanceNumerics.stats()
stddev = stats.stdev()
mean = stats.mean()
reasonableDistances = distanceNumerics.filter(
  lambda x: math.fabs(x - mean) < 3 * stddev)
print reasonableDistances.collect()
