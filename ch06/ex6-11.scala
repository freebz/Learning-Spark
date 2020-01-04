// 예제 6-11 스칼라에서 접속 풀과 JSON 파서 공유

val contactsContactLists = validSigns.distinct().mapPartitions{
  signs =>
  val mapper = createMapper()
  val client = new HttpClient()
  client.start()
  // http 요청 생성
  signs.map {sign =>
    createExchangeForSign(sign)
  // 응답 가져옴
  }.map{ case (sign, exchange) =>
      (sign, readExchangeCallLog(mapper, exchange))
  }.filter(x => x._2 != null)   //빈 콜 로그 삭제
}
