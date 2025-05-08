package controllers

import org.apache.pekko.http.scaladsl.model.HttpHeader.ParsingResult.Ok

import javax.inject._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    var number =2
    Ok(views.html.index())
  }

  def about(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok("https://www.youtube.com/watch?v=HvyHJuC3fRM&list=PLYPFxrXyK0Bx9SBkNhJr1e2-NlIq4E7ED&index=9&ab_channel=RadixCode")
  }

  def welcome(name:String)= Action{implicit request: Request[AnyContent]  =>
    Ok(name)
  }
}
