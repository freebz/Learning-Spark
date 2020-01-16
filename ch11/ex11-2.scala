// 예제 11-2 스칼라의 스팸 분류기

import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.feature.HashingTF
import org.apache.spark.mllib.classification.LogisticRegressionWithSGD

val spam = sc.textFile("spam.txt")
val normal = sc.textFile("normal.txt")

// 이메일 문자열을 10000개 특징의 벡터로 매핑하기 위한 HashingTF 인스턴스를 만드다
val tf = new HashingTF(numFeatures = 10000)
// 각 이메일을 단어로 구분하고 각 단어는 하나의 특성에 매핑된다
val spamFeatures = spam.map(email => tf.transform(email.split(" ")))
val normalFeatures = normal.amp(email => tf.transform(email.split(" ")))

// 양성(스팸)과 음성(일반) 예재를 위해 LabeledPoint 데이터세트 만든다
val positiveExamples = spamFeatures.map(features => LabeledPoint(1, features))
val negativeExamples = normalFeatures.map(features => LabeledPoint(0, features))
val trainingData = positiveExamples.union(negativeExamples)
trainingData.cache() // 로지스틱 회귀는 반복 알고리즘이므로 캐시한다

// SGD 알고리즘으로 로지스틱 회귀를 수행한다
val model = new LogisticRegressionWithSGD().run(trainingData)

// 양성 예제(스팸)와 음성 예제(일반)를 테스트한다
val posTest = tf.transform(
  "O M G GET cheap stuff by sending money to ...".split(" "))
val negTest = tf.transform(
  "Hi Dad, I started studying Spark the other ...".split(" "))
println("Prediction for positive test example: " + model.predict(posTest))
println("Prediction for negative test example: " + model.predict(negTest))
