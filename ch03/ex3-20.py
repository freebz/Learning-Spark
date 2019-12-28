# 예제 3-20 필드 참조가 없는 파이썬 함수 전달

class WordFunctions(object):
  ...
  def getMatchesNoReference(self, rdd):
      # 안점함: 지역 변수에 필요한 필드만 담음
      query = self.query
      return rdd.filter(lambda x: query in x)
