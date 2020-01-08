# 예제 9-19 파이썬에서 파케이에 질의

# 팬더를 좋아하는 사람을 찾는다
tbl = rows.registerTempTable("people")
pandaFriends = hiveCtx.sql("SELECT name FROM people WHERE favouriteAnimal = \"panda\"")
print "Panda friends"
print pandaFriends.map(lambda row: row.name).collect()
