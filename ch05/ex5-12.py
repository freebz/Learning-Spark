# 예제 5-12 파이썬에서 textFile()로 CSV 불러오기

import csv
import StringIO
...
def loadRecord(line):
    """CSV 데이터 한 라인 파싱"""
    input = StringIO.StringIO(line)
    reader = csv.DictReader(input, fieldnames=["name", "favoriteAnimal"])
    return reader.next();
input = sc.textFile(inputFile).map(loadRecord)
