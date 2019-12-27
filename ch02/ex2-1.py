# 예제 2-1 파이썬으로 줄 수 세기

lines = sc.textFile("README.md") # lines라는 RDD를 만든다

lines.count() # 이 RDD의 아이템 개수를 센다
# 127
lines.first() # 이 RDD의 첫 번째 아이템, 이 예제에서는 README.md의 첫 번째 라인
# u'# Apache Spark'
