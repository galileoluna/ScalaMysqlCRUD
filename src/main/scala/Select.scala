import java.sql.{Connection, DriverManager}

object Select extends App {
  // Change to Your Database Config
  val url ="jdbc:mysql://localhost:3306/employees?"
  "user=root&password=root"+"&serverTimezone=UTC"
  var conn: Option[Connection] = None
  try {
    println("Load the driver")
    classOf[com.mysql.jdbc.Driver]
    println("Set up the connection")
    conn = Option(DriverManager.getConnection(url))
    println("Obtain a statement")
    val statement = conn.get.createStatement()
    println("Execute Query")
    val rs =
      statement.executeQuery("SELECT * FROM employee")
    // Iterate Over ResultSet
    println("Results:")
    while (rs.next)
      println(s"${rs.getString("id")}: ${rs.getString("name")}")
  } catch {
    case ex: Exception => ex.printStackTrace()
  } finally conn match {
    case Some(c) => c.close
  }
}
