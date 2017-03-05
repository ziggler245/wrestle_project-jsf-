package controllers.ppv;

import beans.BinarySearch;
import beans.HallPlan;
import beans.ppvPlan;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Serhii Khaliavin
 */
@ManagedBean(eager=true,name="cochampions")
@RequestScoped
public class ClashOfChampions implements Serializable{
    
      static Context ctx=null;
    static DataSource ds=null;
    static Connection connection=null;
     static String query=null;
     static PreparedStatement statement=null;
     static ResultSet rs=null;
    private static ArrayList <HallPlan> hallPlan;
      static public ArrayList<Integer> BinSearch;
      public static ArrayList<ppvPlan> ppvPlan;
      public static int cont;
      
    public ClashOfChampions(){
        
        getClashOfChampionsPlan();
    }
    
    public static void getClashOfChampionsPlan(){
    
        hallPlan=new ArrayList();
         BinSearch=new ArrayList();
         ppvPlan=new ArrayList();
            try{
             ctx = new InitialContext();
             ds = (DataSource) ctx.lookup("wwe_final");
             connection = ds.getConnection();
            if (connection == null)
            {
                throw new SQLException("Error establishing connection!");
            }
            
             
                 query="SELECT *  FROM ppvs_seats where name=\"Clash Of Champions\"";
                statement = connection.prepareStatement(query);
                  rs = statement.executeQuery();
                   while (rs.next()){
                   
                    cont=rs.getInt("seats");
                   }
                 
             query = "SELECT * from ppv_shows where name=\"Clash Of Champions\" group by seat ";
             statement = connection.prepareStatement(query);
             rs = statement.executeQuery();
             while(rs.next()){
             BinSearch.add(rs.getInt("seat"));
             }
            
    for(int i=1;i<=cont;i++){
        
        HallPlan hp = new HallPlan();
        if(BinarySearch.bin(BinSearch, i)==false){
                hp.setId(cont);
                hp.setIdClient(-1);
                hp.setName("Clash Of Champions");
                hp.setSAdd("display:none;");
                hp.setSeat(i);
                hp.setSHidden("display:inline;text-decoration:none;");
 hallPlan.add(hp);
                     
            }else {
        
             query = "SELECT * from ppv_shows where name=\"Clash Of Champions\" and seat="+i;
             statement = connection.prepareStatement(query);
             rs = statement.executeQuery();
             while(rs.next()){
                hp.setId(rs.getInt("id"));
                hp.setIdClient(rs.getInt("id_client"));
                hp.setName("Clash Of Champions");
                hp.setSAdd("display:inline;text-decoration:none;");
                hp.setSeat(i);
                hp.setSHidden("display:none;");
            
             hallPlan.add(hp);
             }
        
        }
        
  }
    }
    catch (SQLException | NamingException ex) {
            Logger.getLogger(ClashOfChampions.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(ClashOfChampions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
        
    }
    
       public ArrayList <HallPlan> getHallPlan(){
      
      return hallPlan;
      
      }
    
}
