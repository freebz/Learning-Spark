// 예제 9-3 스칼라 SQL 내부 모듈 가져오기

// 스파크 SQL HiveContext 생성
val hiveCtx = ...
import hiveCtx.implicits._
