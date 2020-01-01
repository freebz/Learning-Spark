// 예제 5-3 자바에서 텍스트 파일 불러오기

JavaRDD<String> input = sc.textFile("file:///home/holden/repos/spark/README.md");
