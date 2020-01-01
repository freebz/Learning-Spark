// 예제 5-29 스칼라에서 로컬 파일 시스템에 있는 압축 텍스트 파일 불러오기

val rdd = sc.textFile("file:///home/holden/happypandas.gz")
