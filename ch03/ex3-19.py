# 예제 3-19 필드 참조가 포함된 함수 전달하기(이러면 안 됨!)

class SearchFunctions(object):
  def __init__(self, query):
      self.query = query
  def isMatch(self, s):
      return self.query in s
  def getMatchesFunctionReference(self, rdd):
      # 문제: "self.isMatch"를 전달하기 위해서는 "self"도 전달해야 한다. 그로 인해 "self"의 모든 것을 참조하게 된다.
      return rdd.filter(self.isMatch)
  def getMatchesMemberReference(self, rdd):
      # 문제: "self.query"의 "self"의 모든 것을 참조하게 된다
      return rdd.filter(lambda x: self.query in x)
