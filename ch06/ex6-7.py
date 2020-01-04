# 예제 6-7 파이썬에서 브로드캐스트 변수를 쓴 국가 검색

# RDD의 contactCounts에서 콜 사인의 위치를 검색한다.
# 이 검색 작업을 위해 각 국가 코드의 콜 사인 접두어
# 리스트를 불러온다.
signPrefixes = sc.broadcast(loadCallSignTable())

def processSignCount(sign_count, signPrefixes):
    country = lookupCountry(sign_count[0], signPrefixes.value)
    count = sign_count[1]
    return (country, count)

countryContactCounts = (contactCounts
                       .map(processSignCount)
                       .reduceByKey((lambda x, y: x + y)))

countryContactCounts.saveAsTextFile(outputDir + "/contries.txt")
