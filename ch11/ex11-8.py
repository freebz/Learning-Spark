# 예제 11-8 파이썬에서 TF-IDF 사용

from pyspark.mllib.feature import HashingTF, IDF

# 텍스트 파일을 TF 벡터로 읽어 들인다.
rdd = sc.wholeTextFiles("data").map(lambda (name, text): text.split())
tf = HashingTF()
tfVectors = tf.transform(rdd).cache()

# IDF를 계산한 후 TF-IDF 벡터를 계산한다.
idf = IDF()
idfModel = idf.fit(tfVectors)
tfIdfVectors = idfModel.transform(tfVectors)
