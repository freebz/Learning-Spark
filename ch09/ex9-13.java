// 예제 9-13 자바의 topTweets 데이터프레임에 문자열 칼럼(또한 첫 번째 칼럼) 접근하기

JavaRDD<String> topTweetTexts = topTweets.toJavaRDD().map(new function<Row, String>() {
    public String call(Row row) {
	    return row.getString(0);
    }});
