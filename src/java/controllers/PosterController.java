package controllers;


import beans.GetDate;
import beans.PosterPicker;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *Dynamically choose the header's poster(It depends on the month) and link to the ticket to this show
 * @author Serhii Khaliavin
 */
@ManagedBean(name="post_pick")
@SessionScoped
public class PosterController {
 
   static Context ctx=null;
    static DataSource ds=null;
    static Connection connection=null;
     static String query=null;
     static PreparedStatement statement=null;
     static ResultSet rs=null;
    public PosterController(){
   selectPoster();
    }
    
    public static void selectPoster() {
    try{
             ctx = new InitialContext();
             ds = (DataSource) ctx.lookup("wwe_final");
             connection = ds.getConnection();
            if (connection == null)
            {
                throw new SQLException("Error establishing connection!");
            }
             query = "SELECT * FROM ppv where month="+GetDate.get();
             statement = connection.prepareStatement(query);
             rs = statement.executeQuery();
    
    while (rs.next())
            {
               PosterPicker.setPath(rs.getString("path"));
               PosterPicker.setAction(rs.getString("path_2"));
            }
    }
    catch (SQLException | NamingException ex) {
            Logger.getLogger(PosterController.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(PosterController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    
    }
}
