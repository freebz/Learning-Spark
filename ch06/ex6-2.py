# 예제 6-2 파이썬에서 어큐뮬레이터에 빈 라인 개수 세기

file = sc.textFile(inputFile)
# 0으로 초기화한 Accumulator[Int]를 생성한다
blankLines = sc.accumulator(0)

def extractCallSigns(line):
    global blankLines   # 접근할 전역변수로 지정한다
    if (line == ""):
        blankLines += 1
    return line.split(" ")

callSigns = file.flatMap(extractCallSigns)
callSigns.saveAsTextFile(outputDir + "/callsigns")
print "Blank lines: %d" % blankLines.value
