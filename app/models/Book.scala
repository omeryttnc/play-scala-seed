package models

import play.api.data.Form

case class Book(id: Int, title: String, price: Int, author: String)

object BookRepository {
  var books: List[Book] = List(
    Book(1, "book1", 231, "omer1"),
    Book(2, "book2", 232, "omer2"),
    Book(3, "book3", 233, "omer3"),
    Book(4, "book5", 234, "omer4")
  )
  println("all books : "+ books)

  def allBooks: List[Book] =
    books

  def findById(id: Int): Option[Book] =
    books.find(book => book.id == id)

  def add(book: Book): Unit = {
    books = books :+ book
  }


  def update(id: Int, book: Book): Unit = {
    println(s"Updating book with id = $id")

    books.find(_.id == id) match {
      case Some(_) =>
        books = books.filterNot(_.id == id) :+ book
      case None =>
        println(s"Book with id $id not found.")
    }
    println(s"Books after update: $books")

  }

  def remove(book: Book): Boolean =
    if (books.contains(book)) {
      books = books.filterNot(b => b == book)
      true
    } else
      false
}
