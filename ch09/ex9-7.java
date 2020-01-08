// 예제 9-7 자바에서 SQL 컨텍스트 생성

JavaSparkContext ctx = new JavaSparkContext(...);
HiveContext sqlCtx = new HiveContext(ctx);
