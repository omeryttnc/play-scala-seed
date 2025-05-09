package controllers

import com.google.inject.Inject
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents, Request}

class BooksController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  // for all books
  def index(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  // to create book
  def create(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  // to save book
  def save(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  // to edit
  def edit(id: Int): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  // update
  def update(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  // destroy
  def destroy(id: Int): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  // for book details
  def show(id: Int): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

}
