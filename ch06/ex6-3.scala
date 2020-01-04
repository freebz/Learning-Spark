// 예제 6-3 스칼라에서 어큐뮬레이터에 빈 라인 개수 세기

val file = sc.textFile("file.txt")

val blankLines = sc.accumulator(0)   //0으로 초기화한 Accumulator[Int]를 생성한다

val callSigns = file.flatMap(line => {
  if (line == "") {
    blankLines += 1 // 어큐뮬레이터에 더한다
  }
  line.split(" ")
})

callSigns.saveAsTextFile("output.text")
println("Blank lines: " + blankLines.value)
