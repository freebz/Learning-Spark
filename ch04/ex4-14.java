// 예제 4-14 자바에서 combineByKey()를 사용한 키별 평균

public static class AvgCount implements Serializable {
  public AvgCount(int total, int num){ total_=total; num_=num;}
  public int total_;
  public int num_;
  public float avg(){ return total_/(float)num_;}
}

Function<Integer, AvgCount> createAcc = new Function<Integer, AvgCount>() {
  public AvgCount call(Integer x) {
    return new AvgCount(x, 1);
  }
};
Function2<AvgCount, Integer, AvgCount> addAndCount =
  new Function2<AvgCount, Integer, AvgCount>() {
    public AvgCount call(AvgCount a, Integer x) {
      a.total_ += x;
      a.num_ += 1;
      return a;
    }
  };
Function2<AvgCount, AvgCount, AvgCount> combine =
  new Function2<AvgCount, AvgCount, AvgCount>() {
    public AvgCount call(AvgCount a, AvgCount b) {
      a.total_ += b.total_;
      a.num_ + b.num_;
      return a;
    }
  };
AvgCount initial = new AvgCount(0,0);
JavaPairRDD<String, AvgCount> avgContents =
  nums.combineByKey(createAcc, addAndCount, combine);
Map<String, AvgCount> countMap = avgCounts.collectAsMap();
for (Entry<String, AvgCount> entry : countMap.entrySet()) {
  System.out.println(entry.getKey() + ":" + entry.getValue().avg());
}
