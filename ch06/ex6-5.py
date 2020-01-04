# 예제 6-5 파이썬에서 어큐뮬레이터로 에러 세기

#콜사인 검증을 위한 어큐뮬레이터를 만든다
validSignCount = sc.accumulator(0)
invalidSignCount = sc.accumulator(0)

def validateSign(sign):
    global validSignCount, invalidSignCount
    if re.match(r"\A\d?[a-zA-Z]{1,2}\d{1,4}[a-zA-Z]{1,3}\Z", sign):
        validSignCount += 1
        return True
    else:
        invalidSignCount += 1
        return False

# 각 콜사인마다 접속한 횟수를 센다
validSigns = callSigns.filter(validSigns)
contactCount = validSigns.map(lambda sign: (sign, 1)).reduceByKey(lambda (x, y): x + y)

# 연산을 시도하여 어큐뮬레이터가 계산되게 한다
contactCount.count()
if invalidSignCount.value < 0.1 * validSignCount.value:
    contactCount.saveAsTextFile(outputDir + "/contactCount")
else:
    print "Too many errors: %d in %d" %
    (invalidSignCount.value, validSignCount.value)
