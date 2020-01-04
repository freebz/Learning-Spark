// 예제 6-4 자바에서 어큐뮬레이터에 빈 라인 개수 세기

JavaRDD<String> rdd = sc.textFile(args[1]);

final Accumulator<Integer> blankLines = sc.accumulator(0);
JavaRDD<String> callSigns = rdd.flatMap(
  new FlatMapFunction<String, String>() {
    public Iterable<String> call(String line) {
       if (line.equals("")) {
	 blankLines.add(1);
       }
       return Arrays.asList(line.split(" "));
  }});

callSigns.saveAsTextFile("output.txt");
System.out.println("Blank lines: " + `blankLines.value());
