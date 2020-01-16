// 예제 11-5 스칼라에서 벡터 만들기

import org.apache.spark.mllib.linalg.Vectors

// 고밀도 벡터 <1.0, 2.0, 3.0>를 만든다. Vectors.dense는 값들이나 배열을 받는다.
val denseVec1 = Vectors.dense(1.0, 2.0, 3.0)
val denseVec2 = Vectors.dense(Array(1.0, 2.0, 3.0))

// 저밀도 벡터 <1.0, 0.0, 2.0, 0.0>를 만든다. Vectors.sparse는 벡터의 크기와(여기서는 4)
// 0이 아닌 값들의 위치를 받는다.
val sparseVec1 = Vectors.sparse(4, Array(0, 2), Array(1.0, 2.0))
