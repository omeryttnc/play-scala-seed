package controllers

import com.google.inject.Inject
import models.{Book, BookRepository}
import play.api.data.Form
import play.api.data.Forms.{mapping, nonEmptyText, number}
import play.api.i18n.Messages
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents, Request}

class BooksController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  val bookForm: Form[Book]=Form(
    mapping(
      "id"     -> number,
      "title"  -> nonEmptyText,
      "price"  -> number,
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
//    implicit val messages: Messages = messagesApi.preferred(request)
//
//    bookForm.bindFromRequest.fold(
//      formWithErrors => {
//        // Hatalı form varsa tekrar göster
//        BadRequest(views.html.books.create(formWithErrors))
//      },
//      bookData => {
//        // Burada bookData: Book nesnesi olur
//        // İstersen veritabanına kaydedebilirsin
//        Ok(s"Book saved: ${bookData.title}")
//      }
//    )
    println("save method is called ")
    Ok("")
  }

  // to edit
  def edit(id: Int): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(s"edit $id")
  }

  // update
  def update(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok("update")
  }

  // destroy
  def destroy(id: Int): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(s"destroy $id")
  }

  // for book details
  def show(id: Int): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(s"show $id")
  }

}
