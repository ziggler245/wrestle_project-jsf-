package controllers;

import beans.BinarySearch;
import beans.DataSelect;
import beans.User_info;
import beans.Wrestler;
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
 *It displays a list of wrestlers,here you can see which wrestler was added to the favourite list
 * @author Serhii Khaliavin
 */
@ManagedBean(name="wcontrol")
@RequestScoped
public class WrestlerController implements Serializable{
      
   static  private ArrayList <Wrestler> WrestlersList;
   static public ArrayList<Integer> BinSearch;
    static Context ctx = null;
  static   DataSource ds = null;
   static  Connection connection = null;
   static  PreparedStatement statement = null;
  static   ResultSet rs = null;
   static  String query = null;
    static int years;
    static String binary_s="";
    
    
    
    public WrestlerController(){
        showWrestlers();
    }
    
    public static String getSeex(){
 Map<String,String>params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
 return (String.valueOf(params.get("sexx")));
 
 }
  
     public static void getSex()
     {
        
          BinSearch=new ArrayList();
         WrestlersList.clear();
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
                
                    query="SELECT * from f_wrestlers where id_client="+User_info.getId()+" group by id_wrestler";
                statement = connection.prepareStatement(query);
                  rs = statement.executeQuery();
                   while (rs.next()){
                   
                  binary_s+=String.valueOf(rs.getInt("id_wrestler"));
                  binary_s+=" ";
                  BinSearch.add(rs.getInt("id_wrestler"));
                   }
                   
                
                   query = "SELECT * FROM wrestlers where sex=\""+getSeex()+"\"" ;
                  statement = connection.prepareStatement(query);
                  rs = statement.executeQuery();
                
                while (rs.next())
                {   Wrestler wr = new Wrestler();
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
               
               if(BinarySearch.bin(BinSearch, rs.getInt("id"))==false){
            wr.setSAdd("display:inline;float:right;");wr.setSHidden("display:none;");
            }else {
            wr.setSAdd("display:none;");wr.setSHidden("display:inline;");
            }
               WrestlersList.add(wr);
               
                }
                    
            } catch (NamingException | SQLException ex) {
                Logger.getLogger(WrestlerController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(WrestlerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
 
    public static void destroy(){
    WrestlersList=null;
    
  showWrestlers();
  DataSelect.refresh();
    
    }
    
    public   static  void showWrestlers(){
       WrestlersList=new ArrayList();
        BinSearch=new ArrayList();
  
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
           
                 query="SELECT * from f_wrestlers where id_client="+User_info.getId()+" group by id_wrestler";
                statement = connection.prepareStatement(query);
                  rs = statement.executeQuery();
                   while (rs.next()){
                  
                  binary_s+=String.valueOf(rs.getInt("id_wrestler"));
                  binary_s+=" ";
                  BinSearch.add(rs.getInt("id_wrestler"));
                   }
                                     
                   query = "SELECT * FROM wrestlers ";
                  statement = connection.prepareStatement(query);
                  rs = statement.executeQuery();
               
                while (rs.next())
                    
                                          
                {   Wrestler wr = new Wrestler();
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
             
            if(BinarySearch.bin(BinSearch, rs.getInt("id"))==false){
            wr.setSAdd("display:inline;float:right;");wr.setSHidden("display:none;");
            
            }else {
            wr.setSAdd("display:none;");wr.setSHidden("display:inline;");
            }
               WrestlersList.add(wr);
              }
            } catch (NamingException | SQLException ex) {
                Logger.getLogger(WrestlerController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(WrestlerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         
    }
    
    
    public  ArrayList <Wrestler> getWrestlersList(){
      
      return WrestlersList;
      
      }
    
    
}
