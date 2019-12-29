# 예제 4-1 파이썬에서 첫 번째 단어를 키로 사용한 페어 RDD 생성

pairs = lines.map(lambda x: (x.split(" ")[0], x))
