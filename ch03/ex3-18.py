# 예제 3-18 파이썬에서 함수 전달하기

word = rdd.filter(lambda s: "error" in s)

def containsError(s):
    return "error" in s
word = rdd.filter(containsError)
