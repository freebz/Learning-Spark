# 예제 6-16 파이썬에서 pipe()로 finddistance.R을 호출하는 드라이버 프로그램

#외부 R 프로그램으로 각 콜마다 거리를 계산한다
distScript = "./src/R/finddistance.R"
distScriptName = "finddistance.R"
sc.addFile(distScript)
def hasDistInfo(call):
    """콜이 거리 계산에 필요한 필드를 모두 갖고 있는지 확인 """
    requiredFields = ["mylat", "mylong", "contactlat", "contactlong"]
    return all(map(lambda f: call[f], requiredFields))
def formatCall(call):
    """R이 프로그램에서 파싱하고 좋도록 콜 포맷을 바꾼다 """
    return "{0},{1},{2},{3}".format(
        call["mylat"], call["mylong"],
        call["contactlat"], call["contactlong"])

pipeInputs = contactsContactList.values().flatMap(
    lambda calls: map(formatCall, filter(hasDistInfo, calls)))
distances = pipeInputs.pipe(SparkFiles.get(distScriptName))
print distances.collect()
