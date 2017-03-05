package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Serhii Khaliavin
 */
@ManagedBean
@RequestScoped
public class HallPlan implements Serializable{
    
   private int id ;
    private String name;
    int seat;
   private  int idClient;
   private String sAdd;
   private String sHidden;
    
    public HallPlan(){
    }
    
    public void setId(int id){
    
        this.id=id;
    
    }
    
    public int getId(){
    
        return id;
    
    }
    
    public void setName(String  name){
    
        this.name=name;
    
    }
    
    public String getName(){
    
        return name;
    
    }
    
    public void setSeat(int seat){
    
        this.seat=seat;
    
    }
    
    public int getSeat(){
    
        return seat;
    
    }
    
    public void setIdClient(int idClient){
    
        this.idClient=idClient;
    
    }
    
    public int setIdClient(){
    
        return idClient;
    
    }
    
    public void setSHidden(String sHidden){
    
        this.sHidden=sHidden;
    }
    
    public String getSHidden(){
    
    return sHidden;
    }
    
    public void setSAdd(String sAdd){
    
        this.sAdd=sAdd;
    }
    
    public String getSAdd(){
    
    return sAdd;
    }
}
