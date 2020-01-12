// 예제 10-29 스칼라에서 한 디렉터리 안에 쓰여지는 텍스트 파일들을 스트리밍하기

val logData = ssc.textFileStream(logDirectory)
