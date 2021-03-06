// 예제 8-2 스칼라에서 SparkConf를 이용하여 애플리케이션 생성

// conf를 만든다
val conf = new SparkConf()
conf.set("spark.app.name", "My Spark App")
conf.set("spark.master", "local[4]")
conf.set("spark.ui.port", "36000") // 기본 포트 재정의

// 이 설정으로 SparkContext를 만든다
val sc = new SparkContext(conf)
