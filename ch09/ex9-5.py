# 예제 9-5 파이썬 SQL 내부 모듈 가져오기

# 스파크 SQL 임포팅
from pyspark.sql import HiveContext, Row
# 혹은 하이브 의존성이 없을 경우
from pyspark.sql import SQLContext, Row
