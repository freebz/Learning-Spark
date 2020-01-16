// 예제 11-6 자바에서 벡터 만들기

import org.apache.spark.mllib.linalg.Vector;
import org.apache.spark.mllib.linalg.Vectors;

// 고밀도 벡터 <1.0, 2.0, 3.0>를 만든다. Vectors.dense는 값들이나 배열을 받는다.
Vector denseVec1 = Vectors.dense(1.0, 2.0, 3.0);
Vector denseVec2 = Vectors.dense(new double[] {1.0, 2.0, 3.0});

// 저밀도 벡터 <1.0, 0.0, 2.0, 0.0>를 만든다. Vectors.sparse는 벡터의 크기와(여기서는 4)
// 0이 아닌 값들의 위치를 받는다
Vector sparseVec1 = Vectors.sparse(4, new int[] {0, 2}, new double[]{1.0, 2.0});
