// 예제 5-40 스칼라에서 카산드라 속성 설정

val conf = new SparkConf(true)
        .set("spark.cassandra.connection.host", "hostname")

val sc = new SparkContext(conf)
