// 예제 8-10 이미 캐싱된 RDD 연산

// RDD를 캐시한다
counts.cache()
// 첫 번째 실행은 두 단계를 필요로 한다
counts.collect()
// res0: Array[(String, Int)] = Array((ERROR,1), (INFO,4), (WARN,2), (##,1))
// ((empty,2))
counts.collect()
// res1: Array[(String, Int)] = Array((ERROR,1), (INFO,4), (WARN,2), (##,1))
// ((empty,2))
