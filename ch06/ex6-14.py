# 예제 6-14 파이썬에서 mapPartitions()으로 평균 계산

def partitionCtr(nums):
    """파티션에서 sumCount 계산"""
    sumCount = [0, 0]
    for num in nums:
        sumCount[0] += num
        sumCount[1] += 1
    return [sumCount]

def fastAvg(nums):
    """평균값 계산 """
    sumCount = nums.mapPartitions(partitionCtr).reduce(combineCtrs)
    return sumCount[0] / float(sumCount[1])
