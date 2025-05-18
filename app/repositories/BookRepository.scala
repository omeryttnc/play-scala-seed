package repositories

import models.Book
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.SQLiteProfile
import slick.jdbc.SQLiteProfile.api._

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

class BookTable(tag: Tag) extends Table[Book](tag, "books") {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)

  def title = column[String]("title")

  def price = column[Int]("price")

  def author = column[String]("author")

  def * = (id.?, title, price, author) <> (Book.tupled, Book.unapply)
}

@Singleton
class BookRepository @Inject()(
                                dbConfigProvider: DatabaseConfigProvider
                              )(implicit ec: ExecutionContext) {

  private val db = dbConfigProvider.get[SQLiteProfile].db

  val books = TableQuery[BookTable]

  def init(): Future[Unit] = db.run(books.schema.createIfNotExists)

  def create(book: Book): Future[Int] = db.run(books += book)

  def list(): Future[Seq[Book]] = db.run(books.result)

  def get(id: Int): Future[Option[Book]] = db.run(books.filter(_.id === id).result.headOption)

  def update(book: Book): Future[Int] = db.run(books.filter(_.id === book.id).update(book))

  def delete(id: Int): Future[Int] = db.run(books.filter(_.id === id).delete)
}
