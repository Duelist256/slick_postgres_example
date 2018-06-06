//import slick.jdbc.PostgresProfile.api._
//
//import scala.concurrent.Await
//import scala.concurrent.ExecutionContext.Implicits.global
//import scala.concurrent.duration.Duration

// Version for slick 3.2.3

//object Main2 {
//
//  case class Bike(id: Long, hasBasket: Boolean)
//
//  class Bikes(tag: Tag) extends Table[Bike](tag, "bike") {
//    def id = column[Long]("id")
//    def hasBasket = column[Boolean]("has_basket")
//    override def * = (id,hasBasket) <> (Bike.tupled, Bike.unapply)
//  }
//
//  def main(args: Array[String]): Unit = {
//    // specify configuration from your db
//    val dbName: String = ???
//    val username: String = ???
//    val password: String = ???
//    val connectionUrl = s"jdbc:postgresql://localhost/$dbName?user=$username&password=$password"
//
//    val db = Database.forURL(connectionUrl, driver = "org.postgresql.Driver")
//
//    val bikes = TableQuery[Bikes]
//    val f = db.run(bikes.result).map(_.foreach {
//      case Bike(id, hasBasket) => println(s"$id has basket: $hasBasket")
//    })
//
//    Await.result(f, Duration.Inf)
//
//    // SELECT * FROM users WHERE username='john'
//    val f2 = db.run(bikes.result).map(_.filter(_.hasBasket).foreach {
//      case Bike(id, hasBasket) => println(s"bike №$id has basket")
//    })
//
//    Await.result(f2, Duration.Inf)
//  }
//}