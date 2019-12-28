# 예제 3-29 여러 라인을 단어로 분해하는 파이썬의 flatMap()

lines = sc.parallelize(["hello world", "hi"])
words = lines.flatMap(lambda line: line.split(" "))
words.first() # "hello"를 반환
