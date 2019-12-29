// 예제 4-25 스칼라 페이지 랭크

// 이웃 리스트는 스파크 오브젝트 파일에 저장되어 있다고 가정한다
val links = sc.objectFile[(String, Seq[String])]("links")
              .partitionBy(new HashPartitioner(100))
              .persist()

// 각 페이지의 랭크를 1.0으로 초기화한다. mapValues()를 사용하므로
// 결과 RDD는 links와 동일한 파티셔너를 가진다.
var ranks = links.mapValues(v => 1.0)

// 알고리즘 10회 반복 수행
for (i <- 0 until 10) {
  val contributions = links.join(ranks).flatMap {
    case (pageId, (links, rank)) =>
      links.map(dest => (dest, rank / links.size))
  }
  ranks = contributions.reduceByKey((x, y) => x + y).mapValues(v => 0.15 + 0.85*v)
}

// 최종 결과 기록
ranks.saveAsTextFile("ranks")
