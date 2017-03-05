package controllers;

import beans.Comment;
import beans.Htags;
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
import javax.faces.event.ValueChangeEvent;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *Displays the records on the page
 * @author Serhii Khaliavin
 */
@ManagedBean(name="comments")
@RequestScoped
public class IndexController implements Serializable{
  private static ArrayList <Comment> comment=new ArrayList() ;
  public static String  action;

    public int countOneMenu=4;
  private static int del_begin=0;
    String spli[];
       
   public  int getCountOneMenu(){
       
       return  countOneMenu;
   
    }
    
    public  void setCountOneMenu(int  countOneMenu){
    
        this.countOneMenu=countOneMenu;
    }
   
 public int del_begin(){
 return del_begin;
 }
 
 public void del_begin(int del_begin){
 
 this.del_begin=del_begin;
 }
 
 public int counts=2;
  public static int all_count;
  static Integer genre_id=1;
  String search;
  
  public String getSearch(){
  
  return search;
  
  }
  
   public void setSearch(String search){
  
  this.search=search;
  
  }
  
   static Context ctx = null;
       static     DataSource ds = null;
      static      Connection connection = null;
       static     PreparedStatement statement = null;
      static       ResultSet rs = null;
  
  
public IndexController(){
getComments_2();

}
  
 public  int  showResult(String s){
    
    try{
     Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
         genre_id = Integer.valueOf(params.get("action"));
        
        if((genre_id==0)||(genre_id==1)){return 0;}
       return (((genre_id-1)*countOneMenu));
         }catch(NumberFormatException e){return 0;
         }
   
      
   }
  
 public int getCounts(){
 
 //if(all_count%counts==0)return counts;else return (all_count%counts);
 if(all_count-(genre_id*countOneMenu)>=0){return countOneMenu;}else return (Math.abs(all_count-(genre_id*countOneMenu)));
 }
 int h_cont=0;
String [] spl;
  public  void getComments_2(){
    
comment.clear();

            try {
                ctx = new InitialContext();
                 ds = (DataSource) ctx.lookup("wwe_final");
                connection = ds.getConnection();
                  String query = "SELECT * FROM posts limit "+showResult(action)+","+getCounts();
                  statement = connection.prepareStatement(query);
                  rs = statement.executeQuery();
             
               
                while (rs.next())
                {   Comment com = new Comment();
              ArrayList<Htags> list = new ArrayList();
              com.setAuthor(rs.getString("commentor_login"));
               com.setContent(rs.getString("comment"));
               com.setHtags(rs.getString("h_tags"));
               
             spl=rs.getString("h_tags").split(" ");
               
                for(int i=0;i<spl.length;i++){
                    if(spl[i].startsWith("#")){
        Htags ht = new Htags();
        ht.setHesht(spl[i]);
                    list.add(ht);}
         
        }
              
                comment.add(com);
                
              
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
    
 public  void getComments_3(ValueChangeEvent event){
    
comment.clear();
           
            try {
                ctx = new InitialContext();
                 ds = (DataSource) ctx.lookup("wwe_final");
                connection = ds.getConnection();
                  String query = "SELECT * FROM posts limit "+showResult(action)+","+getCounts();
                  statement = connection.prepareStatement(query);
                  rs = statement.executeQuery();
                              
                while (rs.next())
                {   Comment com = new Comment();
               com.setAuthor(rs.getString("commentor_login"));
               com.setContent(rs.getString("comment"));
                
                comment.add(com);
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
 
 public static String getLogin(){
 Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
      return (String.valueOf(params.get("action_2"))); 
 }
 
 public static String getHtag(){
 Map<String,String>params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
 return (String.valueOf(params.get("h_tag1")));
 
 }
 
  
 
 public  static String getComments_4(){
    
comment.clear();
            try {
                ctx = new InitialContext();
                 ds = (DataSource) ctx.lookup("wwe_final");
                connection = ds.getConnection();
                  String query = "SELECT * FROM posts where commentor_login="+getLogin();
                  statement = connection.prepareStatement(query);
                  rs = statement.executeQuery();
                
                while (rs.next())
                {   Comment com = new Comment();
               com.setAuthor(rs.getString("commentor_login"));
               com.setContent(rs.getString("comment"));
               com.setHtags(rs.getString("h_tags"));
               comment.add(com);
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
           
    return "result_author";
    
    }
 
 public   String Search(){
    
comment.clear();

            try {
                ctx = new InitialContext();
                 ds = (DataSource) ctx.lookup("wwe_final");
                connection = ds.getConnection();
                  String query = "SELECT * FROM posts where comment LIKE \"%"+search+"%\"";
                  statement = connection.prepareStatement(query);
                  rs = statement.executeQuery();
                
               
                while (rs.next())
                {   Comment com = new Comment();
               com.setAuthor(rs.getString("commentor_login"));
               com.setContent(rs.getString("comment"));
               com.setHtags(rs.getString("h_tags"));
               comment.add(com);
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
           
    return "result_author";
    
    }
  
  public  static String getHtags(){
    
comment.clear();
            try {
                ctx = new InitialContext();
                 ds = (DataSource) ctx.lookup("wwe_final");
                connection = ds.getConnection();
                  String query = "SELECT * FROM posts where h_tags=\""+getHtag()+"\"";
                  statement = connection.prepareStatement(query);
                  rs = statement.executeQuery();
                               
                while (rs.next())
                {   Comment com = new Comment();
                com.setAuthor(rs.getString("commentor_login"));
               com.setContent(rs.getString("comment"));
                com.setHtags(rs.getString("h_tags"));
             
                comment.add(com);
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
           
    return "result_author";
    
    }

    public ArrayList <Comment> getComment(){
    
      return comment;
      
      }
   
   
}
