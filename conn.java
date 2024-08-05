import java.sql.*;

public class conn {

  Connection con;
  Statement statement;

  public conn() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      con =
        DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/employeemanagement",
          "root",
          "7533"
        );
      statement = con.createStatement();
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
