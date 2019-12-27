# 예제 2-4 파이썬 핕러링 예제

lines = sc.textFile("README.md")

pythonLines = lines.filter(lambda line: "Python" in line)

pythonLines.first()
# u'## Intervactive Python Shell'
