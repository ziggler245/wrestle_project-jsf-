package controllers;

import beans.User_info;
import beans.Wrestler;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

/**
 *It shows favorite wrestlers
 * @author Serhii Khaliavin
 */
@ManagedBean(eager=true,name="fwcontrol")
@RequestScoped
public class FWrestlerController implements Serializable{
      
   static  private ArrayList <Wrestler> WrestlersList=new ArrayList();
    
    
    static Context ctx = null;
  static   DataSource ds = null;
   static  Connection connection = null;
   static  PreparedStatement statement = null;
  static   ResultSet rs = null;
   static  String query = null;
    static int years;
    
    public FWrestlerController(){
        showWrestlers();
    }
  
      public static void refresh()  {
      ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
       try {
           ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
       } catch (IOException ex) {
           Logger.getLogger(FWrestlerController.class.getName()).log(Level.SEVERE, null, ex);
       }
}
    
      private  static String previousPage = null;
 
  public static void checkF5() {
    FacesContext context = FacesContext.getCurrentInstance();
String viewId = context.getViewRoot().getViewId();
ViewHandler handler = context.getApplication().getViewHandler();
UIViewRoot root = handler.createView(context, viewId);
root.setViewId(viewId);
context.setViewRoot(root);
  }
      
        static ArrayList <Integer> intArray=new ArrayList();
    public static String getSeex(){
 Map<String,String>params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
 return (String.valueOf(params.get("sexx")));
 
 }
  
     public static void getSex()
     {
          WrestlersList.clear();
           intArray.clear();
  
               try {
                ctx = new InitialContext();
                 ds = (DataSource) ctx.lookup("wwe_final");
                connection = ds.getConnection();
                query="SELECT YEAR(CURRENT_DATE) as years";
                statement = connection.prepareStatement(query);
                  rs = statement.executeQuery();
                   while (rs.next()){
                  
                  years=(rs.getInt("years"));
                   }
                                
                   query = "SELECT * FROM f_wrestlers where id_client="+User_info.getId();
                  statement = connection.prepareStatement(query);
                  rs = statement.executeQuery();
                             
                while (rs.next())
                { 
                   intArray.add(rs.getInt("id_wrestler"));
                    
                }
                
                for (int i=0;i<intArray.size();i++){
                  query = "SELECT * FROM wrestlers where id="+intArray.get(i)+" and sex=\""+getSeex()+"\"";
                  statement = connection.prepareStatement(query);
                  rs = statement.executeQuery(); 
                while(rs.next()){
                Wrestler wr = new Wrestler();
               wr.setName(rs.getString("name"));
               wr.setBornBegin(rs.getString("born_begin"));
               wr.setGrowth(rs.getInt("growth"));
               wr.setDebut(rs.getInt("debut"));
               wr.setImgPath(rs.getString("img_path"));
               wr.setYears(years-rs.getInt("born_begin"));
               wr.setWeight(rs.getInt("weight"));
               wr.setFinishers(rs.getString("finishers"));
               wr.setSex(rs.getString("sex"));
               
               WrestlersList.add(wr);
                
                }
                  
                  
                }
                    
                  
            } catch (NamingException | SQLException ex) {
                Logger.getLogger(FWrestlerController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(FWrestlerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     
    }
 
    
    
    public static void showWrestlers(){
        WrestlersList.clear();
        intArray.clear();
                 try {
                ctx = new InitialContext();
                 ds = (DataSource) ctx.lookup("wwe_final");
                connection = ds.getConnection();
                query="SELECT YEAR(CURRENT_DATE) as years";
                statement = connection.prepareStatement(query);
                  rs = statement.executeQuery();
                   while (rs.next()){
                  
                  years=(rs.getInt("years"));
                   }
                                
                   query = "SELECT * FROM f_wrestlers where id_client="+User_info.getId();
                  statement = connection.prepareStatement(query);
                  rs = statement.executeQuery();
                             
                while (rs.next())
                { 
                    System.out.println("name name + "+rs.getInt("id"));
                    intArray.add(rs.getInt("id_wrestler"));
                    
                }
                
                for (int i=0;i<intArray.size();i++){
                  query = "SELECT * FROM wrestlers where id="+intArray.get(i);
                  statement = connection.prepareStatement(query);
                  rs = statement.executeQuery(); 
                while(rs.next()){
                Wrestler wr = new Wrestler();
               wr.setName(rs.getString("name"));
               wr.setBornBegin(rs.getString("born_begin"));
               wr.setGrowth(rs.getInt("growth"));
               wr.setDebut(rs.getInt("debut"));
               wr.setImgPath(rs.getString("img_path"));
               wr.setYears(years-rs.getInt("born_begin"));
               wr.setWeight(rs.getInt("weight"));
               wr.setFinishers(rs.getString("finishers"));
               wr.setSex(rs.getString("sex"));
                wr.setId(rs.getInt("id"));
               
               WrestlersList.add(wr);
                
                }
                  
                  
                }
               
            } catch (NamingException | SQLException ex) {
                Logger.getLogger(FWrestlerController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(FWrestlerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
           
    }
    
    
    public ArrayList <Wrestler> getWrestlersList(){
      
      return WrestlersList;
      
      }
    
    
}
