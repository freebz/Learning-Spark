// 예제 3-21 스칼라에서의 함수 전달

class SearchFunctions(val query: String) {
  def isMatch(s: String): Boolean = {
    s.contains(query)
  }
  def getMatchesFunctionReference(rdd: RDD[String]): RDD[Boolean] = {
    // 문제: "isMatch"는 "this.isMatch"이므로 this의 모든 것이 전달된다.
    rdd.map(isMatch)
  }
  def getMatchesFieldReference(rdd: RDD[String]): RDD[Array[String]] = {
    // 문제: "query"는 "this.query"이므로 this의 모든 것이 전달된다.
    rdd.map(x => x.split(query))
  }
  def getMatchesNoReference(rdd: RDD[String]): RDD[Array[String]] = {
    // 안점함: 필요한 필드만 추출하여 지역 변수에 저장해 전달한다.
    val query_ = this.query
    rdd.map(x => x.split(query_))
  }
}
