package models

case class Book(id: Int, title: String, price: Int, author: String)

object BookRepository {
  var books: Set[Book] = Set(
    new Book(1, "book1", 23, "omer"),
    new Book(2, "book1", 23, "omer"),
    new Book(3, "book1", 23, "omer"),
    new Book(4, "book1", 23, "omer")
  )


  def allBooks: Set[Book] =
    books

  def findById(id: Int): Option[Book] =
    books.find(book => book.id == id)

  def add(book: Book): Set[Book] =
    books + book

  def remove(book: Book): Boolean =
    if (books.contains(book)) {
      books -= book
      true
    } else
      false
}
