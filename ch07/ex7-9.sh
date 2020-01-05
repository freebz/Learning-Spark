# 예제 7-9 sbt로 빌드된 스파크 애플리케이션 패키징

sbt assembly
# 결과 디렉터리에서 어셈블리 JAR를 볼 수 있다
ls target/scala-2.10/
my-project-assembly.jar
# 어셈블리 JAR의 내용을 보면 의존성 라이브러리에서 클래스들을 보여 준다
jar tf target/scala-2.10/my-project-assembly.jar
...
joptsimple/HelpFormatter.class
...
org/joda/time/tz/UTCProvider.class
...
# 어셈블리 JAR를 바로 spark-submit에 전달 가능하다
/path/to/spark/bin/spark-submit --master local ...
  target/scala-2.10/my-project-assembly.jar
