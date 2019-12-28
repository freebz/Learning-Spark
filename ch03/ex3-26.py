# 예제 3-26 파이썬에서 RDD의 값들을 제곱하기

nums = sc.parallelize([1, 2, 3, 4])
squared = nums.map(lambda x: x * x).collect()
for num in squared:
    print "%i " % (num)
