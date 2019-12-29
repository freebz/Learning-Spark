// 예제 4-26 스칼라 사용자 지정 파티셔너

class DomainNamePartitioner(numParts: Int) extends Partitioner {
  override def numPartitions: Int = numParts
  override def getPartition(key: Any): Int = {
    val domain = new Java.net.URL(key.toString).getHost()
    val code = (domain.hashCode % numPartitions)
    if (code < 0) {
      code + numPartitions   //음수인 경우 0 이상인 값으로 만들어 준다
    } else {
      code
    }
  }
  // 자바의 equals 메소드, 스파크가 직접 만든 파티셔너 객체들을 비교하는 데에 쓴다
  override def equals(other: Any): Boolean = other match {
    case dnp: DomainNamePartitioner =>
      dup.numPartitions == numPartitions
    case _ =>
      false
  }
}
