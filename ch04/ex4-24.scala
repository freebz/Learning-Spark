// 예제 4-24 RDD의 파티셔너 정하기

val pairs = sc.parallelize(List((1, 1), (2, 2), (3, 3)))

// pairs: spark.RDD[(Int, Int)] = ParallelCollectionRDD[0] at parallelize at <console>:12

pairs.partitioner
// res0: Option[spark.Partitioner] = None

import org.apache.spark.HashPartitioner
// import org.apache.spark.HashPartitioner

val partitioned = pairs.partitionBy(new HashPartitioner(2))
// partitioned: spark.RDD[(Int, Int)] = ShuffledRDD[1] at partitionBy at <console>:14

partitioned.partitioner
// res1: Option[spark.Partitioner] = Some(spark.HashPartitioner@5147788d)
