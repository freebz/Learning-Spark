# 예제 5-34 파이썬에서 스파크 SQL로 JSON 읽기

tweets = hiveCtx.jsonFile("tweets.json")
tweets.registerTempTable("tweets")
results = hiveCtx.sql("SELECT user.name, text FROM tweets")
