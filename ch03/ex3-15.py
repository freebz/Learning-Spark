# 예제 3-15 파이썬에서 액션을 사용해 에러 세기

print "Input had " + badLinesRDD.count() + " concerning lines"
print "Here are 10 examples:"
for line in badLinesRDD.take(10):
    print line
