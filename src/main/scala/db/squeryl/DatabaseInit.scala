package db.squeryl
import com.mchange.v2.c3p0.ComboPooledDataSource
import org.squeryl.adapters.H2Adapter
import org.squeryl.{Session, SessionFactory}


object DatabaseInit {
  def apply() = new DatabaseInit{}
}

trait DatabaseInit {
  val user = "root"
  val pass = ""
  val jdbcUrl = "jdbc:h2:mem:squeryltryout"
  val driverClass = "org.h2.Driver"

  var cpds = new ComboPooledDataSource

  def init() {
    cpds.setDriverClass(driverClass)
    cpds.setJdbcUrl(jdbcUrl)
    cpds.setUser(user)
    cpds.setPassword(pass)

    cpds.setMinPoolSize(4)
    cpds.setAcquireIncrement(2)
    cpds.setMinPoolSize(8)

    SessionFactory.concreteFactory = Some(()=>Session.create(cpds.getConnection, new H2Adapter))
  }

  def close() {
    cpds.close()
  }
}
