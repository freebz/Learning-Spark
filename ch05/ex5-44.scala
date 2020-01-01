// 예제 5-44 스칼라에서 카산드라에 저장하기

val rdd = sc.parallelize(List(Seq("moremagic", 1)))
rdd.saveToCassandra("text" , "kv", SomeColumns("key", "value"))
