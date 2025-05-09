package controllers

import com.google.inject.Inject
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents, Request}

class BooksController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  // for all books
  def index(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok("index")
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
