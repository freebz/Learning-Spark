# 예제 3-35 파이썬의 aggregate()

sumCount = nums.aggregate((0, 0),
              (lambda acc, value: (acc[0] + value, acc[1] + 1),
              (lambda acc1, acc2: (acc1[0] + acc2[0],  acc1[1] + acc2[1]))))
return sumCount[0] / float(sumCount[1])
