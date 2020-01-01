# 예제 5-30 파이썬에서 HiveContext를 생성하고 데이터 가져오기

from pyspark.sql import HiveContext

hiveCtx = HiveContext(sc)
rows = hiveCtx.sql("SELECT name, age FROM users")
firstRow = rows.first()
print firstRow.name
