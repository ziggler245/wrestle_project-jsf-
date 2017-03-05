package controllers;

import beans.Comment;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *Dynamically calculates the number of pages
 * @author Serhii Khaliavin
 */
@ManagedBean(eager = true,name="pagination")
@RequestScoped

public class PaginationController implements Serializable{
    
    private  int count;
    Context ctx = null;
    DataSource ds = null;
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    String query = null;
    
    public PaginationController(){
        getCountPages();
    }
    
 public  static  double   del_count=3;//number of records on page
 public static int del_begin=0;
    
 public int del_begin(){
 return del_begin;
 }
 
 public void del_begin(int del_begin){
 
 this.del_begin=del_begin;
 }
 
    public  void SetCount(int count){
    
        this.count=count;
    
    }
    
    public   int getCount (){
    
        return count;
    }
    
    public void getCountPages(){
    
            
             
            try {
                ctx = new InitialContext();
                 ds = (DataSource) ctx.lookup("wwe_final");
                connection = ds.getConnection();
                   query = "SELECT count(*) as col FROM forum.posts ;";
                  statement = connection.prepareStatement(query);
                  rs = statement.executeQuery();
                while (rs.next())
                {   Comment com = new Comment();
             count=(rs.getInt("col"));
              IndexController.all_count=count;
                             
                }
                
                count=(int)Math.floor(count/del_count);
            } catch (NamingException | SQLException ex) {
                Logger.getLogger(PaginationController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(PaginationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
