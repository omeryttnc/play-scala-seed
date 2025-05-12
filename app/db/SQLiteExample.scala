package db

import java.sql.{Connection, DriverManager, ResultSet}
import java.io.File

object SQLiteExample {
  def main(args: Array[String]): Unit = {

    val file = new File("app/db/database.db")
    val database = file.getAbsolutePath.replace("/", "\\")
    val url = s"jdbc:sqlite:$database" // This creates a new file `sample.db` in your project directory

    // Connect to SQLite
    val conn: Connection = DriverManager.getConnection(url)

    try {
      val stmt = conn.createStatement()
      stmt.execute("CREATE TABLE IF NOT EXISTS Book (id INTEGER PRIMARY KEY, title TEXT, price INTEGER, author TEXT)")

      stmt.execute("INSERT INTO Book (title,price,author) VALUES ('Alice title 1',22,'Alice 1')")
      stmt.execute("INSERT INTO Book (title,price,author) VALUES ('Alice title 2',22,'Alice 2')")
      stmt.execute("INSERT INTO Book (title,price,author) VALUES ('Alice title 3',22,'Alice 3')")
      stmt.execute("INSERT INTO Book (title,price,author) VALUES ('Alice title 4',22,'Alice 4')")

//      val rs: ResultSet = stmt.executeQuery("SELECT * FROM Book")
//      while (rs.next()) {
//        println(s"User: ${rs.getInt("id")} - ${rs.getString("name")}")
//      }
    } finally {
      conn.close()
    }
  }
}
