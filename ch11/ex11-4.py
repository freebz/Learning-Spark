# 예제 11-4 파이썬에서 벡터 만들기

from numpy import array
from pyspark.mllib.linalg import Vectors
# 고밀도 벡터 <1.0, 2.0, 3.0>을 만든다.
denseVec1 = array([1.0, 2.0, 3.0]) # NumPy 배열은 MLlib에 직접 전달할 수 있다.
denseVec2 = Vectors.dense([1.0, 2.0, 3.0]) # ... 혹은 Vectors 클래스를 쓸 수 있다.

# 저밀도 벡터 <1.0, 0.0, 2.0, 0.0>을 만든다. 이를 위한 메소드들은 벡터의 크기와(4)
# 0이 아닌 값의 위치들만을 받아들인다.
# 이것들은 딕셔너리 타입이나 인덱스와 값으로 이루어진 두 개의 리스트로 전달될 수 있다.
sparseVec1 = Vectors.sparse(4, {0: 1.0, 2: 2.0})
sparseVec2 = Vectors.sparse(4, [0, 2], [1,0, 2.0])
