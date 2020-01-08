// 예제 9-39 자바 UDF로 문자열 길이 구하기

hiveCtx.udf().register("stringLengthJava", new UDF1<String, Integer>() {
    @Override
    public Integer call(String str) throws Exception {
      return str.length();
    }
  }, DataTypes.IntegerType);
DataFrame tweetLength = hiveCtx.sql(
  "SELECT stringLengthJava('text') FROM tweets LIMIT 10");
