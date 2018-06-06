import scala.slick.driver.PostgresDriver.simple._

// Version for slick 2.1.0

object Main {

  case class Bike(id: Long, hasBasket: Boolean)

  class Bikes(tag: Tag) extends Table[Bike](tag, "bike") {
    def id = column[Long]("id")
    def hasBasket = column[Boolean]("has_basket")
    override def * = (id,hasBasket) <> (Bike.tupled, Bike.unapply)
  }

  def main(args: Array[String]): Unit = {
    // specify configuration from your db
    val dbName: String = ???
    val username: String = ???
    val password: String = ???
    val connectionUrl = s"jdbc:postgresql://localhost/$dbName?user=$username&password=$password"

    val db = Database.forURL(connectionUrl, driver = "org.postgresql.Driver")


    Database.forURL(connectionUrl, driver = "org.postgresql.Driver") withSession {
      implicit session =>
        val bikes = TableQuery[Bikes]

        // SELECT * FROM users
        bikes.list foreach { row =>
          println("user with id " + row.id + " has basket " + row.hasBasket)
        }

        // SELECT * FROM users WHERE username='john'
        bikes.filter(_.hasBasket).list foreach { row =>
          println(s"user whose id is ${row.id} has basket: ${row.hasBasket}")
        }
    }
  }
}