package controllers

import javax.inject._
import play.api.mvc._
import repositories.UserRepository
import models.User
import slick.jdbc.SQLiteProfile.api._
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class UserController @Inject()(cc: ControllerComponents)(implicit ec: ExecutionContext) extends AbstractController(cc) {

  val db = Database.forConfig("slick.dbs.default.db")
  val repo = new UserRepository(db)
  repo.init() // veritabanını başlat

  def index() = Action.async {
    repo.list().map(users => Ok(users.map(_.name).mkString(", ")))
  }

  def addUser(name: String, email: String) = Action.async {
    repo.insert(User(0, name, email)).map(_ => Ok("User added"))
  }
}
