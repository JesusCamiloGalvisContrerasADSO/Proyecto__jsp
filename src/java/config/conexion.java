
package config;
import java.sql.Connection;
import java.sql.DriverManager;


public class conexion {
    
    Connection con;
    public conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto", "root", "");
            
        } catch (Exception e) {
            System.err.println("Error:"+e);
        }
    }
    public static void main(String[] args) {
        conexion cn=new conexion();
    }

    public Connection getConnection() {
        return con;
    }
}
