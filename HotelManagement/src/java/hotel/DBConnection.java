package hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection
{
    public static Connection myGetConnection()
    {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hotel5", "hotel5");
            return con;
        } catch (SQLException ex) {
            System.out.println("Exception is:"+ex.getMessage());
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("Exception is:"+ex.getMessage());
            return null;
        }
    }

    public static void close(Statement st)
    {
        try
        {
            st.close();
        }
        catch (SQLException ex)
        {
            System.out.println("Exception is:"+ex.getMessage());
        }
    }

    public static void close(Connection con)
    {
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println("Exception is:"+ex.getMessage());
        }
    }


}




