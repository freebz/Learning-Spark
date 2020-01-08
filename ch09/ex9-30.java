// 예제 9-30 자바에서 자바빈(JavaBean)으로부터 DataFrame 만들기

class HappyPerson implements Serializable {
  private String name;
  private String favouriteBeverage;
  public HappyPerson() {}
  public HappyPerson(String n, String b) {
    name = n; favouriteBeverage = b;
  }
  public String getName() { return name; }
  public void setName(String n) { name = n; }
  public String getFavouriteBeverage() { return favouriteBeverage; }
  public void setFavouriteBeverage(String b) { favouriteBeverage = b; }
};
...
ArrayList<HappyPerson> peopleList = new ArrayList<HappyPerson>();
peopleList.add(new HappyPerson("holden", "coffee"));
JavaRDD<HappyPerson> happyPeopleRDD = sc.parallelize(peopleList);
DataFrame happyPeopleDataFrame = hiveCtx.createDataFrame(happyPeopleRDD,
  HappyPerson.class);
happyPeopleDataFrame.registerTempTable("happy_people");
