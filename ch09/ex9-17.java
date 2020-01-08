// 예제 9-17 자바에서 하이브 읽기

import org.apache.spark.sql.hive.HiveContext;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.DataFrame;

HiveContext hiveCtx = new HiveContext(sc);
DataFrame rows = hiveCtx.sql("SELECT key, value FROM mytable");
JavaRDD<Integer> keys = rdd.toJavaRDD().map(new Function<Row, Integer>() {
  public Integer call(Row row) { return row.getInt(0); }
});
