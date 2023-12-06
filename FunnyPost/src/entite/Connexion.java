package entite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
  
  
  public static Connection connectBDD() throws SQLException {
    try {
        String url = "jdbc:mysql://localhost:3306/java";
        String LOGIN = "root";
        String PWD = "";
        
        Class.forName("com.mysql.jdbc.Driver");

        Connection cn = DriverManager.getConnection(url, LOGIN, PWD);
        
        return cn;
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
        throw new SQLException("Erreur lors de la connexion à la base de données", e);
    }
  }
  
  
  public Connexion() throws SQLException {
    Connexion.connectBDD();
  }

}
