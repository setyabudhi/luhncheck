package LuhnCheck;

public class LUHNCheckDigit  {

    
    public static void main(String[] args) {
		// TODO Auto-generated method stub   	
    	int luhn6 = getLuhn("936001531002905634");
    	
    	System.out.println("luhn = "+luhn6);
    	
    	boolean bol = checkLuhn("936001531002905634"+luhn6);
    	
    	System.out.println("LUHN is "+bol);    
	        
	}
 
      
    /**
     * Calulate Luhn Key algorithm.
     * 
     * @param pan
     *            pan
     * @return int result of Luhn check
     */
    public static int getLuhn(String pan) {
        int sum = 0;   
        int nComp = pan.length() % 2;
        for (int i = pan.length() - 1; i >= 0; i--) {
            char c = pan.charAt(i);
          
            int currentvalue = c - 48;
            if (i % 2 != nComp) {
                currentvalue *= 2;
            }
            if (currentvalue > 9) {
                currentvalue = 1 + currentvalue % 10;
            }
            sum += currentvalue;
        }

        sum = 10 - sum % 10;
        if (sum == 10) {
            sum = 0;
        }
        
        return sum;
    }
    
    

    /**
     * Luhn Key algorithm.
     * 
     * @param panWithLuhn
     *            pan
     * @return boolean result of Luhn check
     */
    public static boolean checkLuhn(String panWithLuhn) {
        int sum = 0;
        String luhn = panWithLuhn.substring(panWithLuhn.length() - 1);
        String check = panWithLuhn.substring(0, panWithLuhn.length() - 1);
        int nComp = check.length() % 2;
        for (int i = check.length() - 1; i >= 0; i--) {
            char c = check.charAt(i);
          
            int currentvalue = c - 48;
            if (i % 2 != nComp) {
                currentvalue *= 2;
            }
            if (currentvalue > 9) {
                currentvalue = 1 + currentvalue % 10;
            }
            sum += currentvalue;
        }

        sum = 10 - sum % 10;
        if (sum == 10) {
            sum = 0;
        }
        if (sum != luhn.charAt(0) - 48) {
            return false;
        } else {
            return true;
        }
    }
}

