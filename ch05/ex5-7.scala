// 예제 5-7 스칼라에서 JSON 불러오기

import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.DeserializationFeature
...
case class Person(name: String, lovesPandas: Boolean) // 최상위 레벨 클래스여야 함
...
// 파싱하여 지정된 케이스 클래스에 담는다. 문제가 생기면 빈 리스트(None)를
// 되돌려 주기 위해 flatMap을 사용했으며 모두 괜찮다면 아이템 하나가 들어 있는 리스트를
// 되돌려 준다(Some(_)).
val result = input.flatMap(record => {
  try {
    Some(mapper.readValue(record, classOf[Person]))
  } catch {
    case e: Exception => None
  }})
