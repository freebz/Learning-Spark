// 예제 10-14 스칼라의 DStream에 transform() 사용

val outlierDStream = accessLogsDStream.transform { rdd =>
  extractOutliers(rdd)
}
