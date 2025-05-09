error id: `<none>`.
file:///D:/Projelerim/SCALA/youtube_project/play-scala-seed/app/controllers/HomeController.scala
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -javax/inject/welcomeView.
	 -javax/inject/welcomeView#
	 -javax/inject/welcomeView().
	 -play/api/mvc/welcomeView.
	 -play/api/mvc/welcomeView#
	 -play/api/mvc/welcomeView().
	 -views/html/Home.welcome.
	 -views/html/Home.welcome#
	 -views/html/Home.welcome().
	 -welcomeView.
	 -welcomeView#
	 -welcomeView().
	 -scala/Predef.welcomeView.
	 -scala/Predef.welcomeView#
	 -scala/Predef.welcomeView().
offset: 187
uri: file:///D:/Projelerim/SCALA/youtube_project/play-scala-seed/app/controllers/HomeController.scala
text:
```scala
package controllers

import org.apache.pekko.http.scaladsl.model.HttpHeader.ParsingResult.Ok

import javax.inject._
import play.api.mvc._

import views.html.Home.welcome as welcome@@View

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
    Ok(views.html.index())
  }

  def about(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok("about")
  }

  def welcome(name:String,lastName:String)= Action{implicit request: Request[AnyContent]  =>
    Ok(welcome.render(name,lastName))
  }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.