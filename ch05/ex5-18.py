# 예제 5-18 파이썬에서 CSV 쓰기

def writeRecords(records):
    """CSV 레코드들을 쓴다"""
    output = StringIO.StringIO()
    writer = csv.DictWriter(output, fieldnames=["name", "favoriteAnimal"])
    for record in records:
        writer.writerow(record)
    return [output.getvalue()]

pandaLovers.mapPartitions(writeRecords).saveAsTextFile(outputFile)
