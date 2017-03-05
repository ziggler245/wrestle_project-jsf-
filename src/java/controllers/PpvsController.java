package controllers;

import beans.Ppv;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *Displays a complete list of PPV(Pay-Per-Views) show
 * @author Serhii Khaliavin
 */
@ManagedBean(eager=true)
@ApplicationScoped
public class PpvsController implements Serializable{
    private ArrayList <Ppv> ppvList;
    Context ctx = null;
            DataSource ds = null;
            Connection connection = null;
            PreparedStatement statement = null;
             ResultSet rs = null;
             
    public PpvsController(){
    
        fillAllPpv();
    
    }
      private void fillAllPpv(){
    
     
            
             ppvList = new ArrayList();
            try {
                ctx = new InitialContext();
                 ds = (DataSource) ctx.lookup("wwe_final");
                connection = ds.getConnection();
                  String query = "SELECT * FROM ppv ";
                  statement = connection.prepareStatement(query);
                  rs = statement.executeQuery();
                  while (rs.next())
                {   Ppv ppv = new Ppv();
                ppv.setName(rs.getString("name"));
                ppv.setId(rs.getInt("id"));
                ppv.setPath(rs.getString("path_2"));
                ppvList.add(ppv);
                }
            } catch (NamingException | SQLException ex) {
                Logger.getLogger(PpvsController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(PpvsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
          
    }
      
      public ArrayList <Ppv> getPpvList(){
      
      return ppvList;
      
      }
          
}
