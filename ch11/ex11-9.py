# 예제 11-9 파이썬에서 벡터 정량화

from pyspark.mllib.feature import StandardScaler

vectors = [Vectors.dense([-2.0, 5.0, 1.0]), Vectors.dense([2.0, 0.0, 1.0])]
dataset = sc.parallelize(vectors)
scaler = StandardScaler(withMean=True, withStd=True)
model = scaler.fit(dataset)
result = model.transform(dataset)

# 결과: {[-0.7071, 0.7071, 0.0], [0.7071, -0.7071, 0.0])
