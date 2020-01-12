// 예제 10-30 자바에서 한 디렉터리 안에 쓰여지는 텍스트 파일들을 스트리밍하기

JavaDStream<String> logData = jssc.textFileStream(logsDirectory);
