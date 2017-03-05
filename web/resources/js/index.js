function checkValue(form, message) {
    
    var userInput = form[form.id + ":username"];
    
    if (userInput.value ==''){
        alert(message)
        userInput.focus();
        return false;
    } 
    
    return true;
}

function showProgress(data) {
    
    if (data.status == "begin") {
        
        document.getElementById('loading_wrapper').style.display = "inline";
       
    } else if (data.status == "success") {
        document.getElementById('loading_wrapper').style.display = "none";
    }
}

function clear(){
    
     document.getElementById("forbidden_1:username").value = "";
     document.getElementById("forbidden_1:password").value = "";
    
}

function reload(){
    window.location.reload();
    
}
