package beans;

import java.util.Calendar;

/**
 *
 * @author Serhii Khaliavin
 */

public class GetDate {

  public static int get() {
    Calendar now = Calendar.getInstance();
 
   return now.get(Calendar.MONTH) + 1;
    
  }
}