// 예제 5-35 스칼라에서 스파크 SQL로 JSON 읽기

val tweets = hiveCtx.jsonFile("tweets.json")
tweets.registerTempTable("tweets")
val results = hiveCtx.sql("SELECT user.name, text FROM tweets")
