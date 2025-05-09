package controllers

import org.apache.pekko.http.scaladsl.model.HttpHeader.ParsingResult.Ok

import javax.inject._
import play.api.mvc._
import views.html.home._
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
  def index(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def about(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok("about")
  }

  def welcomePage(name:String,lastName:String): Action[AnyContent] = Action{ implicit request: Request[AnyContent]  =>
    Ok(welcome(name,lastName))
  }
}
