# 예제 5-9 파이썬에서 JSON 저장하기

(data.filter(lambda x: x['lovesPandas']).map(lambda x: json.dumps(x))
  .saveAsTextFile(outputFile))
