# 예제 4-12 파이썬에서 combineByKey()를 사용한 키별 평균

sumCount = nums.combineByKey((lambda x: (x,1)),
                            (lambda x, y: (x[0] + y, y[1] + 1)),
                            (lambda x, y: (x[0] + y[0], x[1] + y[1])))
sumCount.map(lambda key, xy: (key, xy[0]/xy[1])).collectAsMap()
