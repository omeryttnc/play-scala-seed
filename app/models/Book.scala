package models

import play.api.data.Form


case class Book(id: Option[Int], title: String, price: Int, author: String)


