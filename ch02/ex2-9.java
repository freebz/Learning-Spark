// 예제 2-9 자바에서 스파크 초기화하기

import org.apache.spark.SparkConf;
import org.apache.spark.api.Java.JavaSparkContext;

SparkConf conf = new SparkConf().setMaster("local").setAppName("My App");
JavaSparkContext sc = new JavaSparkContext(conf);
