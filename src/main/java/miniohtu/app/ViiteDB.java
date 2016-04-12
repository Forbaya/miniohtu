
package miniohtu.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViiteDB {
    
    public static void resetDB(String dbname) throws ClassNotFoundException {
        // load the sqlite-JDBC driver using the current class loader
        Connection connection = null;
        Class.forName("org.sqlite.JDBC");
        try {
            // create a database connection
            connection = DriverManager.getConnection(String.format("jdbc:sqlite:%s", dbname));
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("DROP TABLE IF EXISTS article");
            statement.executeUpdate(
              "CREATE TABLE article ("
              + "id string,"
              + "author string,"
              + "title string,"
              + "journal string,"
              + "volume integer,"
              + "number integer,"
              + "year integer,"
              + "pages string,"
              + "publisher string,"
              + "address string)"
            );
            // adding one article row for testing
            statement.executeUpdate(
              "INSERT INTO article VALUES("
              + "'W04',"
              + "'Whittington, Keith J.',"
              + "'Infusing active learning into introductory programming courses)',"
              + "'J. Comput. Small Coll.',"
              + "19,"
              + "5,"
              + "2004,"
              + "'249--259',"
              + "'Consortium for Computing Sciences in Colleges',"
              + "'USA')"
            );
            ResultSet rs = statement.executeQuery("SELECT * FROM article");
            while(rs.next()) {
              // read the result set
              System.out.println("id = " + rs.getString("id"));
              System.out.println("author = " + rs.getString("author"));
              System.out.println("title = " + rs.getString("title"));
              System.out.println("journal = " + rs.getString("journal"));
              System.out.println("volume = " + rs.getInt("volume"));
              System.out.println("number = " + rs.getInt("number"));
              System.out.println("year = " + rs.getInt("year"));
              System.out.println("pages = " + rs.getString("pages"));
              System.out.println("publisher = " + rs.getString("publisher"));
              System.out.println("address = " + rs.getString("address"));
            }
        }
        catch(SQLException e) {
          // if the error message is "out of memory", 
          // it probably means no database file is found
          System.err.println(e.getMessage());
        }
        finally {
            try {
                if(connection != null) {
                  connection.close();
                }
            }
            catch(SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }
    }
}