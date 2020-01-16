# 예제 11-7 파이썬에서 HasingTF 사용

from pyspark.mllib.feature import HashingTF

sentence = "hello hello world"
words = sentence.split() # 문장을 단어들의 리스트로 분해한다.
tf = HashingTF(10000) # S=10000 크기의 벡터를 만든다.
tf.transform(words)
# SparseVector(10000, {3065: 1.0, 6861: 2.0})

rdd = sc.wholeTextFiles("data").map(lambda (name, text): text.split())
tfVectors = tf.transform(rdd) # 전체 RDD를 변형한다
