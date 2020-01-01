# 예제 5-20 파이썬에서 시퀀스 파일 불러오기

val data = sc.sequenceFile(inFile,
  "org.apache.hadoop.io.Text", "org.apache.hadoop.io.IntWritable")
