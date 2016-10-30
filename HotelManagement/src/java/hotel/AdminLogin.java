package hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;


public class AdminLogin
{
  
//-------------------------------------------------------------------------------------------------
    public static Adminstrator login(String adminid,String pwd)
    {
        Connection con = null;
        PreparedStatement ps = null;
        try
        {
            ResultSet rs = null;
            con = DBConnection.myGetConnection();
            ps = con.prepareStatement("select adminname,email from admin where adminid=? and pwd=?");

            ps.setString(1, adminid);
            ps.setString(2, pwd);

            rs= ps.executeQuery();
            if(rs.next())
            {
                Adminstrator admin=new Adminstrator();
                admin.setAdminid(adminid);
                admin.setAdminname(rs.getString("adminname"));
                admin.setEmail(rs.getString("email"));

                return admin;
            }
            else
                return null;
        }
        catch (SQLException ex)
        {
            System.out.println("Exception is:"+ex.getMessage());
            return null;
        }
        finally
        {
            DBConnection.close(con);
            DBConnection.close(ps);
        }

    }
//-----------------------------------------------------------------

    public static String getHintQuestion(String email)
    {
        Connection con=null;
        PreparedStatement ps=null;

        try
        {
            con=DBConnection.myGetConnection();
            ps=con.prepareStatement("select hintq from admin where email=?");

            ps.setString(1, email);
            ResultSet rs=ps.executeQuery();

            if(rs.next())
                return rs.getString(1);
            else
                return null;
        }
        catch (SQLException ex)
        {
            System.out.println("Exception is:"+ex.getMessage());
            return null;
        }
        finally
        {
            DBConnection.close(con);
            DBConnection.close(ps);
        }

  }
//-----------------------------------------------------------------------------------------
public static String processForgotPassword(String email,String hinta)
{
        Connection con = null;
        PreparedStatement ps = null;
       
        try
        {
            con = DBConnection.myGetConnection();
            ps = con.prepareStatement("select pwd from admin where email=? and hinta=?");

            ps.setString(1, email);
            ps.setString(2, hinta);

            ResultSet rs=ps.executeQuery();

            if(rs.next())
            {
                try{sendMail(email,rs.getString("pwd"));}
                catch(Exception ex){return ex.getMessage();}
                return null;
            }
            else
                return "Invalid Hintanswer.....Please try again!!!!!";
        }
        catch (SQLException ex)
        {
             System.out.println("Exception is:"+ex.getMessage());
             return ex.getMessage();
        }
        finally
        {
            DBConnection.close(con);
            DBConnection.close(ps);
        }


}
//--------------------------------------------------------------------------------------

public static void sendMail(String email,String pwd) throws Exception
{
    String from="hotelmanagement.teamproject@gmail.com";

    Properties props=new Properties();

    props.put("mail.smtp.host","smtp.gmail.com");
    props.put("mail.smtp.auth","true");
    props.put("mail.smtp.port","465");
    props.put("mail.smtp.socketFactory.port","465");
    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");

    Session session=Session.getDefaultInstance(props, new Authenticator()
    {
       @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("hotelmanagement.teamproject@gmail.com", "teamproject");
            }
    });

    Message msg=new MimeMessage(session);

        msg.setFrom(new InternetAddress(from));
        msg.setRecipient(Message.RecipientType.TO,new InternetAddress(email));

        msg.setContent("Dear Adminstrator,<p/>Your Password: " + pwd + "<p/>With regards<br/>SSS Associations.com","text/html");

        msg.setSubject("Forgot Password");
        // send message
        System.out.println("Before sending mail...");

        Transport.send(msg);

        System.out.println("After sending mail...");
   }
//-------------------------------------------------------------------------------------------------
}
