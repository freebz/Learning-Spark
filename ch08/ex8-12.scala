// 예제 8-12 카이로를 사용 설정하고 클래스 등록하기

val conf = new SparkConf()
conf.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
// 클래스 등록을 엄격하게 하도록 한다
conf.set("spark.kryo.registrationRequired", "true")
conf.registerKryoClasses(Array(classOf[MyClass], classOf[MyOtherClass]))
