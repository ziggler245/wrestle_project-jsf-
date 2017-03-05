package controllers;

import beans.Comment;
import static controllers.IndexController.action;
import static controllers.IndexController.all_count;
import static controllers.IndexController.genre_id;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Serhii Khaliavin
 */
@ManagedBean(eager=true)
@RequestScoped
public class authorController implements Serializable{
    
    String loginName;
    Context ctx = null;
    DataSource ds = null;
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    String query = null;
    
    
    public authorController(){
    }
    
    
    public String getLoginName(){
    return loginName;
    
    }
    
    public void setLoginName(String loginName){
    
    this.loginName=loginName;
    }
    
    
    
      
 public  String  showResult(){
    /* try{
      FacesContext fc = FacesContext.getCurrentInstance();
      Map<String,String> params = 
      fc.getExternalContext().getRequestParameterMap();
      
      
      action =  params.get("index");
      
      if(action.isEmpty()){System.out.println("0+++++++++");return 0;}else {
          System.out.println(action+"++++++++++++++++++++++++++++");
     return ((Integer.valueOf(action)-1)*2);
      }    
     }
      catch(NullPointerException e){return 0;}
      */
 
     Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
         loginName = String.valueOf(params.get("action"));
         return loginName;
        
        
        
   /* del_begin=Integer.valueOf(s);
    if(del_begin==0){System.out.println("0+++++++++++");return 0;}else{System.out.println(del_begin+"+++++++++++++");
    return (del_begin-1)*2;}*/
      
   }
 
    public void searchPosts(){
      
//sIndexController.
       // comment.clear();
            // System.out.println(all_count+"all_count++");
            //System.out.println(all_count%counts+"all_count + counts");
            try {
                ctx = new InitialContext();
                 ds = (DataSource) ctx.lookup("wwe_final");
                connection = ds.getConnection();
                  String query = "SELECT * FROM posts where commentor_login=55";
                  statement = connection.prepareStatement(query);
                  rs = statement.executeQuery();
                //The JDBC Data source that we just created
               
                while (rs.next())
                {   Comment com = new Comment();
               com.setAuthor(rs.getString("commentor_login"));
               com.setContent(rs.getString("comment"));
                //ppv.setId(rs.getInt("id"));
                //comment.add(com);
                }
            } catch (NamingException | SQLException ex) {
                Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
           
    
    
    }
    
    
}
