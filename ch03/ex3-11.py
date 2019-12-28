# 예제 3-11 파이썬에서의 filter() 트랜스포메이션

inputRDD = sc.textFile("log.txt")
errorsRDD = inputRDD.filter(lambda x: "error" in x)
