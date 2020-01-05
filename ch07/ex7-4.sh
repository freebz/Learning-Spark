# 예제 7-4 다양한 옵션으로 spark-submit 사용하기

# 자바 애플리케이션을 단독 클러스터 모드로 제출
./bin/spark-submit \
--master spark://hostname:7077 \
--deploy-mode cluster \
--class com.databricks.examples.SparkExample \
--name "Example Program" \
--jars dep1.jar,dep2.jar,dep3.jar \
--total-executor-cores 300 \
--executor-memory 10g \
myApp.jar "여기는" "당신의 애플리케이션에" "보낼 옵션을 쓴다"

# 얀 클라이언트 모드에서 파이썬 애플리케이션 제출
export HADOP_CONF_DIR=/opt/hadoop/conf
./bin/spark-submit \
--master yarn \
--py-files somelib-1.2.egg,otherlib-4.4.zip,other-file.py \
--deploy-mode client \
--name "Example Program" \
--queue exampleQueue \
--num-executors 40 \
--executor-memory 10g \
my_script.py "여기는" "당신의 애플리케이션에" "보낼 옵션을 쓴다"
