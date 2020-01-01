// 예제 5-31 스칼라에서 Hivecontext를 생성하고 데이터 가져오기

import org.apache.spark.sql.hive.HiveContext

val hiveCtx = new HiveContext(sc)
val rows = hiveCtx.sql("SELECT name, age FROM users")
val firstRow = rows.first()
println(firstRow.getString(0)) // 0번 필드가 'name' 칼럼이다
