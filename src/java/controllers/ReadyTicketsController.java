package controllers;


import beans.DataSelect;
import beans.User_info;
import beans.ppvPlan;
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
 *Show the purchased tickets
 * @author Serhii Khaliavin
 */
@ManagedBean(eager=true,name="tickets")
@RequestScoped
public class ReadyTicketsController implements Serializable{
    
    static Context ctx = null;
  static   DataSource ds = null;
   static  Connection connection = null;
   static  PreparedStatement statement = null;
  static   ResultSet rs = null;
   static  String query = null;
   
   static  PreparedStatement statement_2 = null;
  static   ResultSet rs_2 = null;
   static  String query_2 = null;
   
  ArrayList <ppvPlan> ppv;
    
    public ReadyTicketsController(){
        showTickets();
    }
 
    
      public     void showTickets(){
        
  ppv=new ArrayList();
               try {
                ctx = new InitialContext();
                 ds = (DataSource) ctx.lookup("wwe_final");
                connection = ds.getConnection();
                
                query="SELECT * from ppv_shows where id_client="+User_info.getId();
                statement = connection.prepareStatement(query);
                  rs = statement.executeQuery();
                 
                         while (rs.next())
                        
                {   ppvPlan wr = new ppvPlan();
                
               wr.SetSeat(rs.getInt("seat"));
              wr.SetName(rs.getString("name"));
             wr.SetPath(make_query(wr.getName()));
                 ppv.add(wr);          
              }
                 
            } catch (NamingException | SQLException ex) {
                Logger.getLogger(ReadyTicketsController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(ReadyTicketsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
           
    
        
        
    
    }
    
      public String make_query(String name){
        Context ctx = null;
     DataSource ds = null;
     Connection connection = null;
     PreparedStatement statement = null;
     ResultSet rs = null;
     String query = null;
      String answer=null;
     try {
                ctx = new InitialContext();
                 ds = (DataSource) ctx.lookup("wwe_final");
                connection = ds.getConnection();
                
                query="SELECT * from ppvs_seats where name=\""+name+"\"";
                statement = connection.prepareStatement(query);
                  rs = statement.executeQuery();
                 
                         while (rs.next())
                        
                {   answer=rs.getString("path_2");
                  
              
              }
                 
            } catch (NamingException | SQLException ex) {
                Logger.getLogger(ReadyTicketsController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(ReadyTicketsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     
     return answer;
      }
      
     public static String getParam(){
 Map<String,String>params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
 return (String.valueOf(params.get("trash_ticket")));
 
     }
     
      public static String getNamePpv(){
 Map<String,String>params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
 return (String.valueOf(params.get("name_ppv")));
 
     }
      
            public static int getSeat(){
 Map<String,String>params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
 return (Integer.valueOf(params.get("seat")));
 
     }
      
      
      public void delete(){
      
          DataSelect.t_delete(getParam(), User_info.getId(),getSeat());
      FWrestlerController.refresh();
      
      }
      
      public void add(){
      
      DataSelect.add(getNamePpv(),User_info.getId(), getSeat());
      FWrestlerController.refresh();
      
      }
      
    public ArrayList <ppvPlan> getPpvList(){
      
      return ppv;
      
      }
    
}
