# 예제 6-13 파이썬에서 mapPartitions() 없이 평균 계산

def combineCtrs(c1, c2):
    return (c1[0] + c2[0], c1[1] + c2[1])

def basicAvg(nums):
    """평균을 계산한다"""
    nums.map(lambda num: (num, 1)).reduce(combineCtrs)
