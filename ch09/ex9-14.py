# 예제 9-14 파이썬의 topTweets 데이터프레임에서 문자열 컬럼 접근하기

topTweetText = topTweets.rdd().map(lambda row: row.text)
