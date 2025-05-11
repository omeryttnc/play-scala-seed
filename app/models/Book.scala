package models

case class Book(id: Int, title: String, price: Int, author: String)

object BookRepository {
  var books: List[Book] = List(
    Book(1, "book1", 231, "omer1"),
    Book(2, "book2", 232, "omer2"),
    Book(3, "book3", 233, "omer3"),
    Book(4, "book5", 234, "omer4")
  )
  println(books)

  def allBooks: List[Book] =
    books

  def findById(id: Int): Option[Book] =
    books.find(book => book.id == id)

  def add(book: Book): List[Book] =
    books :+ book

  def remove(book: Book): Boolean =
    if (books.contains(book)) {
      books = books.filterNot(b => b == book)
      true
    } else
      false
}
