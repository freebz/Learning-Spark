// 예제 10-28 스칼라에서 foreachRDD()로 데이터를 외부 시스템에 저장하기

ipAddressRequestCount.foreachRDD { rdd =>
  rdd.foreachPartition { partition =>
    // 저장 시스템에 대한 연결을 연다(예: DB 연결)
    partition.foreach { item =>
      // 연결을 써서 데이터를 시스템에 보낸다
    }
    // 연결을 닫는다
  }
}
