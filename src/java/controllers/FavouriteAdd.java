package controllers;

import beans.DataSelect;
import beans.User_info;
import beans.Wrestler;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.sql.DataSource;

/**
 *Add wrestler to favourite list
 * @author Serhii Khaliavin
 */
@ManagedBean(eager=true,name="add")
@RequestScoped
public class FavouriteAdd implements Serializable{
    
    static  private ArrayList <Wrestler> WrestlersList=new ArrayList();
    
    
    static Context ctx = null;
  static   DataSource ds = null;
   static  Connection connection = null;
   static  PreparedStatement statement = null;
  static   ResultSet rs = null;
   static  String query = null;
   
    
    public FavouriteAdd(){
    }
    
     public static int getParam(){
 Map<String,String>params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
 return (Integer.parseInt(params.get("id_wrestle")));
 
 
 }     
    
     
     public void f_add(){
     
         DataSelect.f_add(User_info.getId(), getParam());
   
     }
     
     public void f_delete(){
   
         DataSelect.f_delete(User_info.getId(), getParam());
                
     }
     
}
