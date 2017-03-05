package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Serhii Khaliavin
 */
@ManagedBean(eager=true,name="bSearch")
@RequestScoped

public class BinarySearch implements Serializable{
 
    public BinarySearch(){
    
    }
    
    
  public  static boolean BinarySearch_Iter(int[] array, int key)
{
    int left = 0;
    int right = array.length;

    while (true)
    {
        int mid = (left +right) / 2;

        if(left==right){return false;}
        
        if (array[mid] == key)
            //return mid;
return true;
        if (array[mid] > key)
            right = mid;
        else
            left = mid + 1;
    }
}
  
  public static boolean bin(ArrayList<Integer> arr,int digit){
  
  Collections.sort(arr);
   
     int index = Collections.binarySearch(arr,digit);
     if(index<0)return false;else return true;
     
  }

    
}
