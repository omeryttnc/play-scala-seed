package repositories

import models.User
import slick.jdbc.SQLiteProfile.api._
import scala.concurrent.Future

class UserTable(tag: Tag) extends Table[User](tag, "users") {
  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def name = column[String]("name")
  def email = column[String]("email")

  def * = (id, name, email) <> (User.tupled, User.unapply)
}

class UserRepository(db: Database) {

  val users = TableQuery[UserTable]

  def init(): Future[Unit] = db.run(users.schema.createIfNotExists)

  def insert(user: User): Future[Int] = db.run(users += user)

  def list(): Future[Seq[User]] = db.run(users.result)
}
