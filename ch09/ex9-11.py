# 예제 9-11 파이썬에서 트윗 데이터 읽어서 질의하기

input = hiveCtx.jsonFile(inputFile)
# 입력 데이터프레임 등록
input.registerTempTable("tweets")
# retweetCount 기준으로 트윗들을 가져온다
topTweets = hiveCtx.sql("""SELECT text, retweetCount FROM
  tweets ORDER BY retweetCount LIMIT 10""")
