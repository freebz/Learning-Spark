// 예제 8-7 스칼라 스파크 셸에서 텍스트 데이터 처리

// 입력 파일을 읽는다
val input = sc.textFile("input.txt")
// 단어 단위로 나누고 빈 라인을 제거한다
val tokenized = input.
  filter(line => line.size > 0).
  map(line => line.split(" "))
// 각 라인의 첫 번째 단어(로그 레벨)를 추출하여 센다
val counts = tokenized.
  map(words => (words(0), 1)).
  reduceByKey{ (a, b) => a + b }
