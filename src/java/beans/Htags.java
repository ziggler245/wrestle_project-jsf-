package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Serhii Khaliavin
 */
@ManagedBean
@RequestScoped

public class Htags {
 
    private String hesht;
    
    
    public Htags(){
    }
    
    
    public void setHesht(String hesht){
    
    this.hesht=hesht;
        
    }
    
    public String getHesht(){
    
        return hesht;
    
    }
    
    
}
