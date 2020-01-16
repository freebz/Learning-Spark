// 예제 11-15 스칼라 스팸 분류 예제의 파이프라인 API 버전

import org.apache.spark.sql.SQLContext
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.ml.feature.{HasingTF, Tokenizer}
import org.apache.spark.ml.tuning.{CrossValidator, ParamGridBuilder}
import org.apache.spark.ml.evaluation.BinaryClassificationEvaluator

// 문서를 표현하는 클래스 - SchemaRDD로 변환될 것이다.
case class LabeledDocument(id: Long, text: String, label: Double)
val documents = // (LabeledDocument의 RDD 로드)

val sqlContext = new SQLContext(sc)
import sqlContext._

// ML 파이프라인을 세 단계로 설정한다 : 토크나이저, tf, lr
// 각 단계는 SchemaRDD의 칼럼을 출력하고 다음 단계의 입력 칼럼으로 넘겨준다.
val tokenizer = new Tokenizer() // 각 이메일 단어로 분리한다.
  .setInputCol("text")
  .setOutputCol("words")
val tf = new HashingTF() // 이메일 단어들을 10000개 특성의 벡터로 매핑한다.
  .setNumFeatures(10000)
  .setInputCol(tokenizer.getOutputCol)
  .setOutputCol("features")
val lr = new LogisticRegression() // 기본 inputCol으로 "features"를 사용한다.
val pipeline = new Pipeline().setStages(Array(tokenizer, tf, lr))

// 파이프라인을 학습 문서들에 적합하게 맞춘다.
val model = pipeline.fit(documents)

// 아니면 위의 인자들로 fit() 하는 대신 몇몇 인자들에 대해 격자 검색을 하고
// 상호 검증을 통해 최적 모델을 찾을 수도 있다.
val paramMaps = new ParamGridBuilder()
  .addGrid(tf.numFeatures, Array(10000, 20000))
  .addGrid(lr.maxIter, Array(100, 200))
  .build() // 인자들의 모든 경우의 수를 만든다.
val eval = new BinaryClassificationEvaluator()
val cv = new CrossValidator()
  .setEstimator(lr)
  .setEstimatorParamMaps(paramMaps)
  .setEvaluator(eval)
val bestModel = cv.fit(documents)
