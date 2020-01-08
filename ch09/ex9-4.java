// 예제 9-4 자바 SQL 내부 모듈 가져오기

// 스파크 SQL 임포팅
import org.apache.spark.sql.hive.HiveContext;
// 혹은 하이브 의존성이 없을 경우
import org.apache.spark.sql.SQLContext;
// JavaSchemaRDD 임포팅
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
