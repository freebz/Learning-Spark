// 예제 9-12 스칼라의 topTweets 데이터프레임에서 문자열 칼럼(또한 첫 번째 칼럼) 접근하기

val topTweetText = topTweets.rdd().map(row => row.getString(0))
