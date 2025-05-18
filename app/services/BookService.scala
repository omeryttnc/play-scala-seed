package services

import jakarta.inject.Singleton
import models.Book
import repositories.BookRepository

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class BookService @Inject()(repo: BookRepository)(implicit ec: ExecutionContext) {

  def initBooks(): Unit = {
    repo.init().map(_ => println("Book table created or already exists"))
  }

  def listBooks(): Future[Seq[Book]] =
    repo.list()

  def getBook(id: Int): Future[Option[Book]] =
    repo.get(id)

  def addBook(book: Book): Future[Int] =
    repo.create(book)

  def updateBook(book: Book): Future[Int] =
    repo.update(book)

  def deleteBook(id: Int): Future[Int] =
    repo.delete(id)
}
