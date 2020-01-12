// 예제 10-31 스칼라에서 한 디렉터리 안에 쓰여지는 시퀀스 파일들 스트리밍

ssc.fileStream[LongWritable, IntWritable,
    SequenceFileInputFormat[LongWritable, IntWritable]](inputDirectory).map {
    case (x, y) => (x.get(), y.get())
}
