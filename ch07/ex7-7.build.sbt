// 예제 7-7 sbt 0.13으로 빌드한 스파크 애플리케이션을 위한 build.sbt

import AssemblyKeys._

name := "Simple Project"

version := "1.0"

organization := "com.databricks"
scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
    // 스파크 의존성
    "org.apache.spark" % "spark-core_2.10" % "1.3.0" % "provided",
    // 서드파티 라이브러리들
    "net.sf.jopt-simple" % "jopt-simple" % "4.3",
    "joda-time" % "joda-time" % "2.0"
)

// 이 구문은 어셈블리 플러그인 기능들을 포함시킨다
assemblySettings

// 어셈블리 플러그인을 사용하는 JAR를 설정한다
jarName in assembly := "my-project-assembly.jar"

// 스파크는 이미 스칼라를 갖고 있으므로 어셈블리 JAR에서 스칼라를 제외하도록 하는
// 특수한 옵션이다
assemblyOption in assembly :=
  (assemblyOption in assembly).value.copy(includeScala = false)
