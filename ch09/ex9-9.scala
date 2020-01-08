// 예제 9-9 스칼라에서 트윗 데이터 읽어서 질의하기

val input = hiveCtx.jsonFile(inputFile)
// 입력 스키마 RDD 등록
input.registerTempTable("tweets")
// retweetCount 기준으로 트윗들을 가져온다
val topTweets = hiveCtx.sql("SELECT text, retweetCount FROM tweets ORDER BY retweetCount LIMIT 10")
