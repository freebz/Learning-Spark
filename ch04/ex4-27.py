# 예제 4-27 파이썬 사용자 지정 파티셔너

import urlparse

def hash_domain(url):
  return hash(urlparse.urlparse(url).netloc)

rdd.partitionBy(20, hash_domain) # 파티션을 20개 만든다
