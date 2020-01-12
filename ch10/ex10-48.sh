# 예제 10-48 병렬 마크 스윕 GC 활성화

spark-submit --conf spark.executor.extraJavaOptions=-XX:+UseConcMarkSweepGC App.jar
