// 예제 4-21 자바에서 사용자 지정 정렬, 정수를 문자열인 것처럼 정렬하기

class IntegerComparator implements Compare<Integer> {
  public int compare(Integer a, Integer b) {
    return String.valueOf(a).compareTo(String.valueOf(b));
  }
}
rdd.sortByKey(new IntegerComparator);
