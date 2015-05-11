package db.squeryl

import org.squeryl.Schema

class User(val login: String, val password : String) {
  def this() = this("", "")
}

object Users extends Schema {
  val users = table[User]
}
