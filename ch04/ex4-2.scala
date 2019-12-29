// 예제 4-2 스칼라에서 첫 번째 단어를 키로 사용한 페어 RDD 사용

val pairs = lines.map(x => (x.split(" ")(0), x))
