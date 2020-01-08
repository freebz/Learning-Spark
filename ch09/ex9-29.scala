// 예제 9-29 스칼라에서 케이스 클래스로부터 DataFrame 만들기

case class happyPerson(handle: String, favouriteBeverage: String)
...
// HappyPerson을 하나 만들고 Schema RDD로 변환한다
val happyPeopleRDD = sc.parallelize(List(HappyPerson("holden", "coffee")))
// 노트: 내부적 변환이 발생한다
// 즉 sqlCtx.createDataFrame(happyPeopleRDD)와 동일하다.
happyPeopleRDD.registerTempTable("happy_people")
