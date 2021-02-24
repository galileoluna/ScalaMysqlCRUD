import java.sql.{Connection, DriverManager}

object Update extends App{

  val url = "jdbc:mysql://localhost:3306/employees?"
  "user=root&password=root"+"&serverTimezone=UTC"
  var conn: Option[Connection] = None
  try {
    println("Load the driver")
    classOf[com.mysql.jdbc.Driver]
    println("Set up the connection")
    conn = Option(DriverManager.getConnection(url))
    println("Obtain a statement")
    val statement = conn.get.createStatement()
    println("Execute Update")
    val rs = statement.executeUpdate(
      "UPDATE employee SET name='Sofie' WHERE id='3'")
    println(rs)
  } catch {
    case ex: Exception => ex.printStackTrace()
  } finally {
    conn match {
      case Some(c) => c.close
    }
  }

}
