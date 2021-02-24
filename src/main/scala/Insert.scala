import java.sql.{Connection, DriverManager}
object Insert extends App{
  var conn: Option[Connection] = None
  // Change to Your Database Config
  val url = "jdbc:mysql://localhost:3306/employees?"
  "user=root&password=root"+"&serverTimezone=UTC"
  try {
    println("Load the driver")
    classOf[com.mysql.jdbc.Driver]
    println("Set up the connection")
    conn = Option(DriverManager.getConnection(url))
    println("database insert")
    val prep =
      conn.get.prepareStatement(
        "INSERT INTO employee (id, name) VALUES (?, ?) ")
    prep.setString(1, "3")
    prep.setString(2, "Phoebe")
    prep.executeUpdate
    println("Success")
  } catch {
    case ex: Exception => ex.printStackTrace()
  } finally {
    println("Close the connection")
    conn match {
      case Some(c) => c.close
    }
  }
}
