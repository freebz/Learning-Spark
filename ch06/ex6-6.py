# 예제 6-6 파이썬으로 국가 검색

# RDD의 contactCounts에서 콜 사인의 위치를 검색한다.
# 이 검색 작업을 위해 각 국가 카드의 콜 사인 접두어
# 리스트를 불러온다.
signPrefixes = loadCallSignTable()

def processSignCount(sign_count, signPrefixes):
    country = lookupCountry(sign_count[0], signPrefixes)
    count = sign_count[1]
    return (country, count)

countryContactCounts = (contactCounts
                       .map(processSignCount)
                       .reduceByKey((lambda x, y: x + y)))
