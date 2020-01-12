// 예제 10-6 스칼라에서 "error"를 포함하는 라인만을 출력하기 위한 스트리밍 필터

// StreamingContext를 시작하고 "종료"를 기다리게 한다
ssc.start()
// 작업이 끝나기를 기다린다
ssc.awaitTermination()
