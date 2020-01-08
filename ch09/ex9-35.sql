-- 예제 9-35 스파크 SQL 셸에서 EXPLAIN 실행

spark-sql> EXPLAIN SELECT * FROM mytable where key = 1;
== Physical Plan ==
Filter (key#16 = 1)
HiveTableScan [key#16,value#17], (MetastoreRelation default, mytable, None),
None Time taken: 0.551 seconds
