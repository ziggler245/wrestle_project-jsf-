package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *Class for getting information from user
 * @author Serhii Khaliavin
 */
@ManagedBean(name="u_info")
@SessionScoped
public class User_info implements Serializable{
    private static int id;
   private static String login;
   private static String e_mail;
  
   public User_info(){
   
    
   }
   
   public static void setId(int id){
   User_info.id=id;
   }
   
   public static int getId(){
   return id;
   }
   
   public static void setLogin(String login){
   User_info.login=login;
   }
   
   public static String getLogin(){
   
   return login;
   }
    
   public static void Set_e_mail(String e_mail){
   User_info.e_mail=e_mail;
   
   }
   
   public static String Get_e_mail(){
   
   return e_mail;
   }
   
}
