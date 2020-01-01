// 예제 5-43 자바에서 키/값 데이터를 가진 RDD로 전체 테이블 불러오기

import com.datastax.spark.connector.CassandraRow;
import static com.datastax.spark.connector.CassandraJavaUtil.javaFunctions;

// RDD로 전체 테이블을 읽는다. 테이블은 다음처럼 만들어진 걸로 가정한다.
// CREATE TABLE test.kv(key text PRIMARY KEY, value int);
JavaRDD<CassandraRow> data = javaFunctions(sc).cassandraTable("test" , "kv");
// 기본 데이터 통계 출력
System.out.println(data.mapToDouble(new DoubleFunction<CassandraRow>() {
  public double call(CassandraRow row) { return row.getInt("value"); }
}).stats());
