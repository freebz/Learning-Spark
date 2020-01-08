# 예제 9-36 파이썬 UDF로 문자열 길이 구하기

# 리턴해 줄 인티저 타입을 임포트한다
from pyspark.sql.types import IntegerType
# 문자열 길이를 알려 줄 UDF를 만든다
hiveCtx.registerFunction("strLenPython", lambda x: len(x), IntegerType())
lengthDataFrame = hiveCtx.sql("SELECT strLenPython('text') FROM tweets LIMIT 10")
