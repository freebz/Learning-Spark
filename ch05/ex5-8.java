// 예제 5-8 자바에서 JSON 불러오기

class ParseJson implements FlatMapFunction<Iterator<String> Person> {
  public Iterable<Person> call(Iterator<String> lines) throws Exception {
    ArrayList<Person> people = new ArrayList<Person>();
    ObjectMapper mapper = new ObjectMapper();
    while (lines.hasNext()) {
      String line = lines.next();
      try {
	people.add(mapper.readValue(line, Person.class));
      } catch (Exception e) {
	// 예외 발생 시 레코드 무시
      }
    }
    return people;
  }
}
JavaRDD<String> input = sc.textFile("file.json");
JavaRDD<Person> result = input.mapPartitions(new ParseJson());
