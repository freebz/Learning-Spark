// 예제 5-42 스칼라에서 키/값 데이터를 가진 RDD로 전체 테이블 불러오기

// SparkContext와 RDD에 함수를 추가
import com.datastax.spark.connector._

// RDD로 전체 테이블을 읽는다. 테이블은 다음처럼 만들어진 걸로 가정한다.
// CREATE TABLE test.kv(key text PRIMARY KEY, valeu int);
val data = sc.cassandraTable("text", "kv")
// 기본 데이터 통계 출력
data.map(row => row.getInt("value")).stats()
