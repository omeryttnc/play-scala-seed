package controllers

import com.google.inject.Inject
import models.{Book, BookRepository}
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents, Request}

class BooksController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  // for all books
  def index(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val books: List[Book] = BookRepository.allBooks

    Ok(views.html.books.books(books))
  }

  // to create book
  def create(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok("create")
  }

  // to save book
  def save(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok("save")
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
