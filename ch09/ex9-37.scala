// 예제 9-37 스칼라 UDF로 문자열 길이 구하기

hiveCtx.udf.register("strLenScala", (_: String).length)
val tweetLength = hiveCtx.sql("SELECT strLenScala('tweet') FROM tweets LIMIT 10")
