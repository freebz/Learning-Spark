# 예제 6-10 파이썬에서 접속 풀 공유

def processCallSigns(signs):
    """접속 풀을 써서 콜 사인 검색 """
    # 접속 풀을 만든다
    http = urllib3.PoolManager()
    # 각 콜 사인 기록과 관련된 URL
    urls = map(lambda x: "http://73s.com/qsos/%s.json" % x, signs)
    # 요청 생성(비동기, non-blocking)
    requests = map(lambda x: (x, http.request('GET', x)), urls)
    # 결과 가져옴
    result = map(lambda x: (x[0], json.loads(x[1].data)), requests)
    # 빈 결과를 제거하고 되돌려 줌
    return filter(lambda x: x[1] is not None, result)

def fetchCallSigns(input):
    """콜 사인들을 가져 옴 """
    return input.mapPartitions(lambda callSings : processCallSigns(callSings))

contactsContactList = fetchCallSigns(validSigns)
