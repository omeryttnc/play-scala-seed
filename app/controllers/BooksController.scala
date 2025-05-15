package controllers

import com.google.inject.Inject
import models.{Book, BookRepository}
import play.api.data.Form
import play.api.data.Forms.{mapping, nonEmptyText, number}
import play.api.i18n.Messages
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents, Request}

class BooksController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  val bookForm: Form[Book] = Form(
    mapping(
      "id" -> number,
      "title" -> nonEmptyText,
      "price" -> number,
      "author" -> nonEmptyText
    )(Book.apply)(Book.unapply)
  )

  // for all books
  def index(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val books: List[Book] = BookRepository.allBooks

    Ok(views.html.books.books(books))
  }

  // to create book
  def create(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>

    implicit val messages: Messages = messagesApi.preferred(request)

    Ok(views.html.books.create(bookForm))
  }

  // to save book
  def save(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    implicit val messages: Messages = messagesApi.preferred(request)

    bookForm.bindFromRequest().fold(
      formWithErrors => {
        // Hatalı form tekrar gösterilsin
        BadRequest(views.html.books.create(formWithErrors))
        Redirect(routes.BooksController.index()).flashing("failed" -> "Book not saved")
      },
      bookData => {
        BookRepository.add(bookData)
        Redirect(routes.BooksController.index()).flashing("success" -> "Book saved")
      }
    )
  }


  // to edit
  def edit(id: Int): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val book: Option[Book] = BookRepository.findById(id): Option[Book]
    implicit val messages: Messages = messagesApi.preferred(request)

    book match {
      case Some(value) =>
        val filledForm = bookForm.fill(value)
        Ok(views.html.books.edit(bookForm = filledForm, id = id))
      case None =>
        NotFound("Book not found")
    }
  }

  // update
  def update(id: Int): Action[AnyContent] = Action { implicit request =>
    implicit val messages: Messages = messagesApi.preferred(request)
    println("BooksController update is called")
    bookForm.bindFromRequest().fold(
      formWithErrors => {
        BadRequest(views.html.books.edit(bookForm = bookForm, id = id))
//        Redirect(routes.BooksController.index()).flashing("failed" -> "Book not updated")

      },
      bookData => {
        print(s"book data $bookData")
        BookRepository.update(id, bookData.copy(id = id)) // id'yi sabit tut
        Redirect(routes.BooksController.index()).flashing("success" -> "Book updated")
      }
    )
  }


  // destroy
  def destroy(id: Int): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(s"destroy $id")
  }

  // for book details
  def show(id: Int): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val book: Option[Book] = BookRepository.findById(id): Option[Book]
    implicit val messages: Messages = messagesApi.preferred(request)

    if (book == null)
      NotFound("Book not found")
    else
      Ok(views.html.books.show(book.get))

  }

}
