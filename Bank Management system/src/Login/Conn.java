package Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//package Login;
//import java.sql.*;
//public class Conn {
//    private static final String url="jdbc:mysql://localhost:3306/?user=root";
//    private static final String username="root";
//    private static final String password="kiit";
//     public Conn(){
//         try{
//             Class.forName("com.mysql.cj.jdbc.Driver");
//             Connection c = DriverManager.getConnection("jdbc:mysql:///");
//         }catch (Exception e){
//             System.out.println(e);
//         }
//
//         try{
//             Connection connection=DriverManager.getConnection(url,username,password);
//             Statement statement=connection.createStatement();
//
//         }catch (SQLException e){
//             System.out.println(e.getMessage());
//         }
//
//     }
//
//}
public class Conn {
    Connection c;
    static Statement s;
    public Conn() {
        try {
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagement", "root", "kiit");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}