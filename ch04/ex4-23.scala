// 예제 4-23 스칼라 사용자 지정 파티셔너

val sc = new SparkContext(...)
val userData = sc.sequenceFile[UserID, UserInfo]("hdfs://...")
                 .partitionBy(new HashPartitioner(100)) // 파티션 100개를 만든다.
                 .persist()
