# -*- coding: utf-8 -*-
# 예제 2-7 파이썬에서 스파크 초기화하기

from pyspark import SparkConf, SparkContext

conf = SparkConf().setMaster("local").setAppName("My App")
sc = SparkContext(conf = conf)
