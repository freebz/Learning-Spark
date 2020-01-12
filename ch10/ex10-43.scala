// 예제 10-43 스칼라에서의 SparkFlumeEvent

// 플럼 이벤트가 UTF-8 로그 문자열이라고 가정
val lines = events.map{e => new String(e.event.getBody().array(), "UTF-8")}
