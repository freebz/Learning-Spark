// 예제 5-10 스칼라에서 JSON 저장하기

result.filter(p => p.lovesPandas).map(mapper.writeValueAsString(_))
  .saveAsTextFile(outputFile)
