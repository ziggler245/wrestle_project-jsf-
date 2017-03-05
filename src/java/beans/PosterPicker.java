package beans;

import controllers.PosterController;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Serhii Khaliavin
 */
@ManagedBean(name="poster")
@SessionScoped
public class PosterPicker {
     private static String path;
      private static String action;
    
 public  PosterPicker(){
     PosterController.selectPoster();
 }
 
 public static void setPath(String  path){
 
 PosterPicker.path=path;
 }
 
 public String getPath(){
 
 return path;
 }
 
 public static void setAction(String  action){
 
 PosterPicker.action=action;
 }
 
 public String getAction(){
 
 return action;
 }
    
    
    
}
