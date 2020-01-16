// 예제 11-14 스칼라에서 SVD 수행

// RowMatrix mat의 상위 20개 특이값과 특이 벡터들을 계산한다.
val svd: SingularValueDecomposition[RowMatrix, Matrix] =
  mat.computeSVD(20, computeU=true)

val U: RowMatrix = svd.U // U는 분산된 RowMatrix이다.
val s: Vector = svd.s // 특이값들은 지역적인 고밀도 벡터이다.
val V: Matrix = svd.V // V는 지역적 밀집 행렬이다.
