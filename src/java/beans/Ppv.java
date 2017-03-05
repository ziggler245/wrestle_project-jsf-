package beans;

/**
 *
 * @author Serhii Khaliavin
 */
public class Ppv {
    private String name;
    private int id;
    private String path;
    
    public Ppv(){
    }
    
    public Ppv(String name,int id,String path){
        this.name=name;
        this.id=id;
        this.path=path;
    }
    
    public long getId(){
         return id;
    }
    
    public void setId(int id){
         this.id=id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
         this.name=name;
    
    }
    
     public String getPath(){
        return path;
    }
    
    public void setPath(String path){
         this.path=path;
    
    }
    
}
