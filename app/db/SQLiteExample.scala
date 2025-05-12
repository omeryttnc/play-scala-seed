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
      stmt.execute("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, name TEXT)")

      stmt.execute("INSERT INTO users (name) VALUES ('Alice')")
      stmt.execute("INSERT INTO users (name) VALUES ('Bob')")

      val rs: ResultSet = stmt.executeQuery("SELECT * FROM users")
      while (rs.next()) {
        println(s"User: ${rs.getInt("id")} - ${rs.getString("name")}")
      }
    } finally {
      conn.close()
    }
  }
}
