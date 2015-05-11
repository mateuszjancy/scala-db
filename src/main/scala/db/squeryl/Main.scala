package db.squeryl

//http://www.srirangan.net/2011-03-getting-started-scala-persistence-with-squeryl
object Main extends App {
  import org.squeryl.PrimitiveTypeMode._

  val db = DatabaseInit()
  db.init()

  transaction {
    Users.create
    val u = new User("A", "B")
    Users.users.insert(u)
    val r = Users.users.where(user => user.login === "A").single

    println(r)
  }

  db.close()
}
