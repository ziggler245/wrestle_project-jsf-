package beans;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import mail.ValidateEmail;

/**
 *
 * @author Serhii Khaliavin
 */

@ManagedBean
@SessionScoped
public class User implements Serializable {

    private String username="";
    private String password="";
    private String confirm_password="";
    private String e_mail="";
    private int state=0;
    private static int login_check=0;
    private String e_mail_feedback="";
    private String message_feedback="";

    public User() {
    }
    
    public  String getMessageFeedback() {
        return message_feedback;
    }

        
    public void setMessageFeedback(String MessageFeedback) {
        this.message_feedback = MessageFeedback;
    }
    
    public  String getEmailFeedback() {
        return e_mail_feedback;
    }

        
    public void setEmailFeedback(String EmailFeedback) {
        this.e_mail_feedback = EmailFeedback;
    }

    public  String getUsername() {
        return username;
    }

        
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    
    public String getConfirmPassword(){
    return confirm_password;
    }
    
    public void setConfirmPassword(String confirm_password){
    this.confirm_password=confirm_password;
    
    }
    
     public String getEmail(){
    return e_mail;
    }
    
    public void setEmail(String e_mail){
    this.e_mail=e_mail;
    
    }

    public static void LoginCheck(){
    login_check=1;
    }
    
    public static void LoginUnCheck(){
    login_check=0;
    }
    
    public String login() {
        
        ResourceBundle bundle = ResourceBundle.getBundle("nls.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());
   FacesContext context = FacesContext.getCurrentInstance();
        what:     try {

switch(username.length()){
    case 0:
    FacesMessage message = new FacesMessage(bundle.getString("login_required"));
   message.setSeverity(FacesMessage.SEVERITY_ERROR);
   context.addMessage("forbidden_1:username", message);state=1; break;
}

switch(password.length()){
    case 0:
    FacesMessage message = new FacesMessage(bundle.getString("password_required"));
   message.setSeverity(FacesMessage.SEVERITY_ERROR);
   context.addMessage("forbidden_1:password", message);state=1; break;
}

if(state==1){state=0;break what;}


            ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).login(username, password);
         InetAddress thisIp = null;
            try {
                 thisIp = InetAddress.getLocalHost();
                 
            } catch (UnknownHostException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            DataSelect.check(username, thisIp.toString(),"main");
            return "main";
        } catch (ServletException ex) {
            
            FacesMessage message = new FacesMessage(bundle.getString("forbidden"));
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage("forbidden_1", message);
      
        }

        return null;

    }

    public String registr(){
    
        
       ResourceBundle bundle = ResourceBundle.getBundle("nls.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());
   FacesContext context = FacesContext.getCurrentInstance();
        
switch(username.length()){
    case 0:
    FacesMessage message = new FacesMessage(bundle.getString("login_required"));
   message.setSeverity(FacesMessage.SEVERITY_ERROR);
   context.addMessage("forbidden_1:username", message);state=1; break;
}

switch(e_mail.length()){
    case 0:
    FacesMessage message = new FacesMessage(bundle.getString("email_required"));
   message.setSeverity(FacesMessage.SEVERITY_ERROR);
   context.addMessage("forbidden_1:e_mail", message);state=1; break;
}

switch(password.length()){
    case 0:
    FacesMessage message = new FacesMessage(bundle.getString("password_required"));
   message.setSeverity(FacesMessage.SEVERITY_ERROR);
   context.addMessage("forbidden_1:password", message);state=1; break;
}

switch(confirm_password.length()){
    case 0:
    FacesMessage message = new FacesMessage(bundle.getString("confirm_p"));
   message.setSeverity(FacesMessage.SEVERITY_ERROR);
   context.addMessage("forbidden_1:confirm_password", message);state=1; break;
}
if(state==1){state=0;return null;}

DataSelect.check(username, username, "registration");
switch(login_check){
    case 1:FacesMessage message = new FacesMessage(bundle.getString("login_wrong"));
   message.setSeverity(FacesMessage.SEVERITY_ERROR);
   context.addMessage("forbidden_1:login_wrong", message);state=1; LoginUnCheck();break;

}
if(state==1){state=0;return null;}
if(!ValidateEmail.check(e_mail)){

    FacesMessage message = new FacesMessage(bundle.getString("email_wrong"));
   message.setSeverity(FacesMessage.SEVERITY_ERROR);
   context.addMessage("forbidden_1:email_wrong", message);state=1;


}
if(state==1){state=0;return null;}

if(password.length()<5){

FacesMessage message = new FacesMessage(bundle.getString("password_length_wrong"));
message.setSeverity(FacesMessage.SEVERITY_ERROR);
context.addMessage("forbidden_1:password_length_wrong", message);state=1;
}
if(state==1){state=0;return null;}

if(!confirm_password.equals(password)){
FacesMessage message = new FacesMessage(bundle.getString("password_n_confirm"));
message.setSeverity(FacesMessage.SEVERITY_ERROR);
context.addMessage("forbidden_1:password_n_confirm", message);state=1;

}

if(state==1){state=0;return null;}
DataSelect.insert(username, password, e_mail);

        return "index";
        
    
    
    }
   
      public String feedback(){
    
        
       ResourceBundle bundle = ResourceBundle.getBundle("nls.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());
   FacesContext context = FacesContext.getCurrentInstance();
        

switch(e_mail_feedback.length()){
    case 0:
    FacesMessage message = new FacesMessage(bundle.getString("email_required"));
   message.setSeverity(FacesMessage.SEVERITY_ERROR);
   context.addMessage("forbidden_1:username", message);state=1; break;
}

switch(message_feedback.length()){
    case 0:
    FacesMessage message = new FacesMessage(bundle.getString("enter_message"));
   message.setSeverity(FacesMessage.SEVERITY_ERROR);
   context.addMessage("forbidden_1:password", message);state=1; break;
}

if(state==1){state=0;return null;}

if(!ValidateEmail.check(e_mail_feedback)){

    FacesMessage message = new FacesMessage(bundle.getString("email_wrong"));
   message.setSeverity(FacesMessage.SEVERITY_ERROR);
   context.addMessage("forbidden_1:login_wrong", message);state=1;


}

if(state==1){state=0;return null;}
DataSelect.send(e_mail_feedback,message_feedback);
       return "index";
       
    
    
    }
   
    
    public  String logout() {
        String result = "/index.xhtml?faces-redirect=true";

        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

        try {
            request.logout();
        } catch (ServletException e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
        }

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        return result;
    }
    
}
