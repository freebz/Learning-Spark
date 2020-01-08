# 예제 9-28 파이썬에서 Row와 이름 있는 튜플로 DataFrame 만들기

happyPeopleRDD = sc.parallelize([Row(name="holden", favoriteBeverage="coffee")])
happyPeopleDataFrame = hiveCtx.inferSchema(happyPeopleRDD)
happyPeopleDataFrame.registerTempTable("happy_people")
