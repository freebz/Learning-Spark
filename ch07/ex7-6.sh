# 예제 7-6 메이븐으로 빌드한 스파크 애플리케이션 패키징

mvn package
# 결과 디렉터리에서 우버 JAR와 원래의 패키징 JAR를 볼 수 있다
ls target/
example-build-1.0.jar
original-example-build-1.0.jar
# 우버 JAR의 내용을 보면 의존성 라이브러리들의 목록이 나온다
jar tf target/example-build-1.0.jar
...
joptsimple/HelpFormatter.class
...
org/joda/time/tz/UTCProvider.class
...
# 우버 JAR를 바로 spark-submit에 전달하면 된다
/path/to/spark/bin/spark-submit --master local ... target/example-build-1.0.jar
