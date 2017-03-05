package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Serhii Khaliavin
 */
@ManagedBean(eager=true)
@RequestScoped
public class ppvPlan implements Serializable{
    
    private int id;
    private int seat;
    private String name;
    private String path;
    
    public ppvPlan(){
    }
    
    public void SetPath(String path){
    
        this.path=path;
    }
    
    public String getPath(){
    
    return path;
    }
    
    
    public void SetId(int id){
    
        this.id=id;
    
    }
    
    public int getId(){
    
        return id;
    
    }
    
    public void SetSeat(int seat){
    
        this.seat=seat;
    
    }
    
    public int getSeat(){
    
        return seat;
    
    }
    
     public void SetName(String name){
    
        this.name=name;
    
    }
    
    public String getName(){
    
        return name;
    
    }
    
}
