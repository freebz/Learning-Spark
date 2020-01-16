// 예제 11-13 스칼라에서 PCA 호출

import org.apache.spark.mllib.linalg.Matrix
import org.apache.spark.mllib.linalg.distributed.RowMatrix

val points: RDD[Vector] = // ...
val mat: RowMatrix = new RowMatrix(points)
val pc: Matrix = mat.computePrincipalComponents(2)

// 점들을 저차원 공간(행렬)에 곱한다
val projected = mat.multiply(pc).rows

// K-평균 모델을 곱한 2차원 데이터에서 학습시킨다
val model = KMeans.train(projected, 10)
