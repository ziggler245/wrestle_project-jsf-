package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Serhii Khaliavin
 */
@ManagedBean(eager=true)
@SessionScoped
public class Wrestler implements Serializable{
    
    private String name;
    private String bornBegin;
    private int growth;
    private int debut;
    private  String imgPath;
    private int weight;
    private String finishers;
    private String sex;
    private  int years;
    private  int id;
    private String sAdd;
    private String sHidden;
    
    
    public Wrestler(){
       
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
    
    public void setId(int id){
    
        this.id=id;
    }
    
    public  int getId(){
    
    return id;
    }
    
    public void setName(String name){
    
        this.name=name;
    }
    
    public String getName(){
    
    return name;
    }
    
    public void setBornBegin(String bornBegin){
    
    this.bornBegin=bornBegin;
            
    }
    
    public String getBornBegin(){
    
    return bornBegin;
    }
    
    public void setGrowth(int growth){
   
        this.growth=growth;
    }
    
    public int getGrowth(){
    
        return growth;
    
    }
    
    public void setDebut(int debut){
    
        this.debut=debut;
    
    }
    
    public int getDebut(){
    
        return debut;
    
    }
    
    public  void setImgPath(String imgPath){
    
        this.imgPath=imgPath;
    
    
    }
    
    
    public  String getImgPath(){
    
        return imgPath;
    
    }
    
    public void setWeight(int weight){
    
        this.weight=weight;
        
    
    }
    
    public int getWeight(){
    
        return weight;
    
    }
    
    public void setFinishers(String finishers){
    
        this.finishers=finishers;
    
    }
    
    public String getFinishers(){
    
        return finishers;
    }
    
      public void setSex(String sex){
    
        this.sex=sex;
    
    }
    
    public String getSex(){
    
        return sex;
    } 
    
     public  void setYears(int years){
    
        this.years=years;
    
    }
    
    public  int getYears(){
    
        return years;
    } 
}
