# 예제 9-18 파이썬에서 파케이 읽기

# 파케이 파일에서 필드의 이름과 favouriteAnimal을 써서 읽어 온다
rows = hiveCtx.load(parquetFile, "parquet")
names = rows.map(lambda row: row.name)
print "Everyone"
print names.collect()
