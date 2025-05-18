package controllers

import javax.inject._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.i18n._

import scala.concurrent.{ExecutionContext, Future}
import models.Book
import services.BookService

@Singleton
class BookController @Inject()(
                                cc: MessagesControllerComponents,
                                service: BookService
                              )(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  service.initBooks()

  val bookForm: Form[Book] = Form(
    mapping(
      "id" -> optional(number),
      "title" -> nonEmptyText,
      "price" -> number,
      "author" -> nonEmptyText
    )(Book.apply)(Book.unapply)
  )
  def index() = Action.async {
    service.listBooks().map { books =>
      Ok(views.html.books.books(books.toList))
    }
  }

  def show(id: Int) = Action.async {
    service.getBook(id).map {
      case Some(book) => Ok(views.html.books.show(book))
      case None => NotFound("Book not found")
    }
  }

  def destroy(id: Int) = Action.async {
    service.deleteBook(id).map(_ => Redirect(routes.BookController.index()))
  }

  def create() = Action.async { implicit request: MessagesRequest[AnyContent] =>
    Future.successful(Ok(views.html.books.create(bookForm)))
  }



  def save() = Action.async { implicit request: MessagesRequest[AnyContent] =>
    bookForm.bindFromRequest().fold(
      formWithErrors => Future.successful(BadRequest(views.html.books.create(formWithErrors))),
      bookData => {
        service.addBook(bookData).map { _ =>
          Redirect(routes.BookController.index()).flashing("success" -> "Book saved")
        }
      }
    )
  }


  def edit(id: Int) = Action.async { implicit request: MessagesRequest[AnyContent] =>
    service.getBook(id).map {
      case Some(book) =>
        val filledForm = bookForm.fill(book)
        Ok(views.html.books.edit(filledForm, id))
      case None =>
        NotFound("Book not found")
    }
  }

  def update(id: Int) = Action.async { implicit request: MessagesRequest[AnyContent] =>
    bookForm.bindFromRequest().fold(
      formWithErrors => Future.successful(BadRequest(views.html.books.edit(formWithErrors, id))),
      bookData => {
        service.updateBook(bookData.copy(id = Some(id))).map { _ =>
          Redirect(routes.BookController.index()).flashing("success" -> "Book updated")
        }
      }
    )
  }


}

