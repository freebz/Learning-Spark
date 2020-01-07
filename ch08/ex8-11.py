# 예제 8-11 PySpark 셸에서 큰 RDD로 합치기

# 와일드카드 입력은 수천 개 파일이 될 수도 있다
input = sc.textFile("s3n://log-files/2014/*.log")
input.getNumPartitiosn()
# 35154
# 대부분의 데이터를 제외시키는 필터링
lines = input.filter(lambda line: line.startswith("2014-10-17"))
lines.getNumPartitions()
# 35154
# 캐싱하기 전에 RDD의 lines RDD를 합친다
lines = lines.coalesce(5).cache()
lines.getNumPartitions()
# 5
# 이후의 분석 작업은 합쳐진 RDD상에서 실행된다...
lines.count()
