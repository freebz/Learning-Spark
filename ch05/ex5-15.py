# 예제 5-15 파이썬에서 전체적으로 CSV 불러오기

def loadRecords(fileNameContents):
    """주어진 파일의 모든 레코드를 읽는다"""
    input = StringIO.StringIO(fileNameContents[1])
    reader = csv.DictReader(input, fieldnames=["name", "favoriteAnimal"])
    return reader
fullFileData = sc.wholeTextFiles(inputFile).flatMap(loadRecords)
