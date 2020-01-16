// 예제 11-3 자바의 스팸 분류기

import org.apache.spark.mllib.classification.LogisticRegressionModel;
import org.apache.spark.mllib.classification.LogisticRegressionWithSGD;
import org.apache.spark.mllib.feature.HashingTF;
import org.apache.spark.mllib.linalg.Vector;
import org.apache.spark.mllib.regression.LabeledPoint;

JavaRDD<String> spam = sc.textFile("spam.txt");
JavaRDD<String> normal = sc.textFile("normal.txt");

// 이메일 문자열을 10000개 특성의 벡터로 매핑하기 위한 HashingTF 인스턴스를 만든다
final HashingTF tf = new HashingTF(10000);

// 양성(스팸)과 음성(일반) 예제를 위해 LabeledPoint 데이터세트를 만든다
JavaRDD<LabeledPoint> posExamples = spam.map(new Function<String, LabeledPoint>() {
  public LabeledPoint call(String email) {
    return new LabeledPoint(1, tf.transform(Arrays.asList(email.split(" "))));
  }
});
JavaRDD<LabeledPoint> negExamples = normal.map(new Function<String, LabeledPoint>() {
  public LabeledPoint call(String email) {
    return new LabeledPoint(0, tf.transform(Arrays.asList(email.split(" "))));
  }
});
JavaRDD<LabeledPoint> trainData = positiveExamples.union(negativeExamples);
trainData.cache(); // 로지스틱 회귀는 반복 알고리즘이므로 캐시한다.

// SGD 알고리즘으로 로지스틱 회귀를 수행한다.
LogisticRegressionModel model = new LogisticRegressionWithSGD().run(trainData.rdd());

// 양성 예제(스팸)와 음성 예제(일반)를 테스트한다.
Vector posTest = tf.transform(
  Arrays.asList("O M G GET cheap stuff by sending money to ...".split(" ")));
Vector negTest = tf.transform(
  Arrays.asList("Hi Dad, I started studying Spark the other ...".split(" ")));
System.out.println("Prediction for positive example: " + model.predict(posTest));
System.out.println("Prediction for negative example: " + model.predict(negTest));
