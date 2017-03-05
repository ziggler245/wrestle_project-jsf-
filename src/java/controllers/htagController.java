package controllers;

import beans.Htags;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *Controls the output of hashtags
 * @author Serhii Khaliavin
 */
@ManagedBean(name="htag_c")
@ApplicationScoped
public class htagController implements Serializable{
     private static   ArrayList <Htags> list = new ArrayList();
    public htagController(){
           
    }
    
    
   static String s[];
    String q="";

    public static void checkHtags(String line){
      
        s=line.trim().split(" ");
        
        for(int i=0;i<s.length;i++){
        
            if(s[i].startsWith("#")){
                
                Htags list_ex = new Htags();
                list_ex.setHesht(s[i]);
                list.add(list_ex);}
        }
       
}
    
    public static void clearList(){
    
    list.clear();
    }
    
  public ArrayList <Htags> getList(){
      
      return list;
      
      }  
}
