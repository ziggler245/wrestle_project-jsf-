package beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Serhii Khaliavin
 */
@ManagedBean(eager=true)
@ApplicationScoped
public class Comment {
   private String author;
   private String content;
   private String htags;
   private int test=1;
      

   String spli[];
    public Comment(){
    }

   
    
    public int getTest(){
    
        return test;
    
    }
    
    
    public void setAuthor(String author){
    
        this.author=author;
    }
    
    public String getAuthor(){
    
        return author;
    
    }
    
    public void setContent(String content){
    
        this.content=content;
    }
    
    public String getContent(){
    
    return content;
    
    }
   String h[];
     public void setHtags(String htags){
    
   this.htags=htags;
   
        
    }
    
    public String getHtags(){
    
        return htags;
    
    }
}
      

