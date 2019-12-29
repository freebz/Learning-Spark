// 예제 4-22 스칼라 단순 애플리케이션

// 코드 초기화, 사용자 정보를 HDFS의 하둡 시퀀스 파일에서 읽어 온다.
// 이는 찾아낸 HDFS 블록에 맞춰 userData의 요소들을 적절히 분산시키지만,
// 특별히 스파크에 어떤 ID가 어떤 파티션에 존재하는지에 대해서 정보를 제공하지는 않는다.
val sc = new SparkContext(...)
val userData = sc.sequenceFile[UserID, UserInfo]("hdfs://...").persist()

// 지난 5분간의 이벤트 로그 파일을 처리하기 위해 주기적으로 불리는 함수.
// 여기서 처리하는 시퀀스 파일이 (UserID, LinkInfo) 쌍을 갖고 있다고 가정한다.
def processNewLogs(logFileName: String) {
  val events = sc.sequenceFile[UserID, LinkInfo](logFileName)
     val joined = userData.join(events)  // (UserID, (UserInfo, LinkInfo))를
                                         // 페어로 가지는 RDD
  val offTopicVisits = joined.filter {
    case (userId, (userInfo, linkInfo)) => // 각 아이틍멜 그 컴포넌트들로 확장한다.
      !userInfo.topics.contains(linkInfo.topic)
  }.count()
  println("Number of visits to non-subscribed topics: " + offTopicVisits)
}
