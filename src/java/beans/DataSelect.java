package beans;

import controllers.WrestlerController;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import mail.MailSender;

/**
 *Class for DataBase requests
 * @author Serhii Khaliavin
 */

public class DataSelect {
    
   static Context ctx=null;
   static DataSource ds=null;
   static Connection connection=null;
  static String query=null;
  static Statement stmt=null;
  static PreparedStatement statement=null;
  static ResultSet rs =null;
    
      public static void check(String login_val,String user_agent,String page) {

        try {
             ctx = new InitialContext();
             ds = (DataSource) ctx.lookup("wwe_final");
             connection = ds.getConnection();
            if (connection == null)
            {
                throw new SQLException("Error establishing connection!");
            }
             query = "SELECT * FROM clients where login="+login_val;
             statement = connection.prepareStatement(query);
             rs = statement.executeQuery();
           if(page=="index"){
            while (rs.next())
            {
                try {
                    MailSender.generateAndSendEmail(rs.getString("e_mail"),user_agent) ;
                } catch (MessagingException ex) {
                    Logger.getLogger(DataSelect.class.getName()).log(Level.SEVERE, null, ex);
                }
            }}else if(page=="registration"){
            if(rs.next()){User.LoginCheck();}
            
            
            }else if (page=="main"){
            
                while(rs.next()){
                
                    User_info.setId(rs.getInt("id"));
                    User_info.setLogin("login");
                    User_info.Set_e_mail("e_mail");
                }
                
            }
           

        } catch (SQLException | NamingException ex) {
            Logger.getLogger(DataSelect.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DataSelect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
   public static String sha_256(String in){
        MessageDigest md ;  
        byte []  digest = null;
       try {
              md = MessageDigest.getInstance("SHA-256");
             
              md.update(in.getBytes("UTF-8"));
               digest = md.digest();
             
              
          } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
              Logger.getLogger(DataSelect.class.getName()).log(Level.SEVERE, null, ex);
          }
     return String.format("%064x", new java.math.BigInteger(1, digest));
   
   
   }
       public static void insert(String login_val,String password,String email) {

      
      try {
             ctx = new InitialContext();
            
             ds = (DataSource) ctx.lookup("wwe_final");
             connection = ds.getConnection();
            if (connection == null)
            {
                throw new SQLException("Error establishing connection!");
            }
           stmt = connection.createStatement();
          
          stmt.executeUpdate("insert into  clients(login,password,e_mail) values ('"+login_val+"','"+sha_256(password)+"','"+email+"')");
          
          
            stmt = connection.createStatement();
          
          stmt.executeUpdate("insert into  users_groups(group_id,user_id) values ('user','"+login_val+"')");
         
        } catch (SQLException | NamingException ex) {
            Logger.getLogger(DataSelect.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DataSelect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
       
       
           public static void add(String name,int id,int seat) {

      
      try {
             ctx = new InitialContext();
             ds = (DataSource) ctx.lookup("wwe_final");
             connection = ds.getConnection();
            if (connection == null)
            {
                throw new SQLException("Error establishing connection!");
            }
         
           stmt = connection.createStatement();
          
          stmt.executeUpdate("insert into  ppv_shows(name,seat,id_client) values ('"+name+"','"+seat+"','"+id+"')");
          
          
            stmt = connection.createStatement();
          
       
           

        } catch (SQLException | NamingException ex) {
            Logger.getLogger(DataSelect.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DataSelect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
 
       public static String refreshPage_action() {  
    FacesContext fctx = FacesContext.getCurrentInstance();  
    String pageToRefresh = fctx.getViewRoot().getViewId();   //getting View Id of current page  
    ViewHandler viewHandler = fctx.getApplication().getViewHandler();      
    UIViewRoot viewRoot = viewHandler.createView(fctx, pageToRefresh);   //ViewRoot for current page  
    viewRoot.setViewId(pageToRefresh);  
    fctx.setViewRoot(viewRoot);     //set the viewroot in facesContext to reload  
    return null;  
 } 
       
       
       
       public static void refresh()  {
      ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
       try {
           ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
       } catch (IOException ex) {
           Logger.getLogger(DataSelect.class.getName()).log(Level.SEVERE, null, ex);
       }
}
        public static void f_add(int id_client,int id_wrestler) {

      
      try {
             ctx = new InitialContext();
             ds = (DataSource) ctx.lookup("wwe_final");
             connection = ds.getConnection();
            if (connection == null)
            {
                throw new SQLException("Error establishing connection!");
            }
             stmt = connection.createStatement();
          
          stmt.executeUpdate("insert into  f_wrestlers(id_client,id_wrestler) values ('"+id_client+"','"+id_wrestler+"')");
          
         WrestlerController.destroy();
          
        } catch (SQLException | NamingException ex) {
            Logger.getLogger(DataSelect.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DataSelect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
        
           public static void f_delete(int id_client,int id_wrestler) {

      
      try {
             ctx = new InitialContext();
             ds = (DataSource) ctx.lookup("wwe_final");
             connection = ds.getConnection();
            if (connection == null)
            {
                throw new SQLException("Error establishing connection!");
            }
           stmt = connection.createStatement();
          System.out.println("wrestle_id " + id_wrestler);
          stmt.executeUpdate("delete from  f_wrestlers where id_client="+id_client+" and id_wrestler="+id_wrestler);
        
       WrestlerController.destroy();
        
        } catch (SQLException | NamingException ex) {
            Logger.getLogger(DataSelect.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DataSelect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
           
            public static void t_delete(String name,int id_client,int seat) {

      
      try {
             ctx = new InitialContext();
             ds = (DataSource) ctx.lookup("wwe_final");
             connection = ds.getConnection();
            if (connection == null)
            {
                throw new SQLException("Error establishing connection!");
            }
            stmt = connection.createStatement();
            stmt.executeUpdate("delete from  ppv_shows where id_client="+id_client+" and name=\""+name+"\" and seat=\""+seat+"\"");
                 

        } catch (SQLException | NamingException ex) {
            Logger.getLogger(DataSelect.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DataSelect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
     
       public static void send(String e_mail,String message) {

      
      try {
             ctx = new InitialContext();
             ds = (DataSource) ctx.lookup("wwe_final");
             connection = ds.getConnection();
            if (connection == null)
            {
                throw new SQLException("Error establishing connection!");
            }
           stmt = connection.createStatement();
           stmt.executeUpdate("insert into  messages(e_mail,message) values ('"+e_mail+"','"+message+"')");
          
        } catch (SQLException | NamingException ex) {
            Logger.getLogger(DataSelect.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DataSelect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    
      
}
