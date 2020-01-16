# 예제 11-1 파이썬의 스팸 분류기

from pyspark.mllib.regression import LabeledPoint
from pyspark.mllib.feature import HashingTF
from pyspark.mllib.calssification import LogisticRegressionWithSGD

spam = sc.textFile("spam.txt")
normal = sc.textFile("normal.txt")

# 이메일 문자열을 10000개 특징의 벡터로 매핑하기 위한 HashingTF 인스턴스를 만든다
tf = HashingTF(numFeatures = 10000)
# 각 이메일을 단어로 구분하고 각 단어는 하나의 특성에 매핑된다
spamFeatures = spam.map(lambda email: tf.transform(email.split(" ")))
normalFeatures = normal.map(lambda email: tf.transform(email.split(" ")))

# 양성(스팸)과 음성(일반) 예제를 위해 LabeledPoint 데이터세트를 만든다
positiveExamples = spamFeatures.map(lambda features: LabeledPoint(1, features))
negativeExamples = normalFeatures.map(lambda features: LabeledPoint(0, features))
trainingData = positiveExamples.union(negativeExamples)
trainingData.cache() # 로지스틱 회귀는 반복 알고리즘이므로 캐시한다

# SGD 알고리즘으로 로지스틱 회귀를 수행한다
model = LogisticRegressionWithSGD.train(trainingData)

# 양성 예제(스팸)와 음성 예제(일반)를 테스트한다
# 우선 벡터들을 얻기 위해 동일한 HashingTF 특징 변형을 적용한 후 모델을 적용한다
posTest = tf.transform("O M G GET cheap stuff by sending money to ...".split(" "))
negTest = tf.transform("Hi Dad, I started studying Spark the other ...".split(" "))
print "Prediction for positive test example: %g" % model.predict(posTest)
print "Prediction for negative test example: %g" % model.predict(negTest)
