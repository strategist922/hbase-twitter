package st.happy_camper.hbase.twitter.importer.entity

import _root_.org.codehaus.jackson.JsonNode

class UserMention(
  val id: Long,
  val name: String,
  val screenName: String,
  val indices: String
)

object UserMention {

  def apply(json: JsonNode) : UserMention = {
    new UserMention(
      json.path("id").getLongValue,
      json.path("name").getTextValue,
      json.path("screen_name").getTextValue,
      json.path("indices").toString
    )
  }

  def unapply(json: JsonNode) : Option[UserMention] = {
    try {
      Option(UserMention(json))
    }
    catch {
      case _ => None
    }
  }
}
