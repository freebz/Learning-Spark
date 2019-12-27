// 예제 2-12 sbt 빌드 파일

name := "learning-spark-mini-example"

version := "0.0.1"

scalaVersion := "2.10.4"

// 추가 라이브러리들
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "1.2.0" % "provided"
)
