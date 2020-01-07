// 예제 8-8 스칼라에서 toDebugString()으로 RDD 시각화

input.toDebugString
// res1: String = 
// (2) input.txt MapPartitionsRDD[1] at textFile at <console>:21 []
//  |  input.txt HadoopRDD[0] at textFile at <console>:21 []

counts.toDebugString
// res2: String = 
// (2) ShuffledRDD[5] at reduceByKey at <console>:27 []
//  +-(2) MapPartitionsRDD[4] at map at <console>:26 []
//     |  MapPartitionsRDD[3] at map at <console>:25 []
//     |  MapPartitionsRDD[2] at filter at <console>:24 []
//     |  input.txt MapPartitionsRDD[1] at textFile at <console>:21 []
//     |  input.txt HadoopRDD[0] at textFile at <console>:21 []
