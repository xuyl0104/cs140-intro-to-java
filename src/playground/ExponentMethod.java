package playground;
import java.util.Scanner;

public class ExponentMethod {
	// bad recursion
   public static int raiseToPower(int baseVal, int exponentVal) {
      int resultVal;

      if (exponentVal == 0) {
         resultVal = 1;
      }
      else {
         resultVal = baseVal * raiseToPower(baseVal, exponentVal - 1);
      }

      return resultVal;
   }
   
   // tail recursion
   public static int raiseToPower(int baseVal, int exponentVal, int count, int curVal) {
	   
	   // (5, 4, 0, 1) -> (5, 4, 1, 5*1) -> (5, 4, 2, 5*5) -> (5, 4, 3, 5*25) -> (5, 4, 4, 5*125)
	   if (count == exponentVal) {
		   return curVal;
	   }
	   else {
		   return raiseToPower(baseVal, exponentVal, count + 1, baseVal * curVal);
	   }
   }

   public static void main (String [] args) {
      Scanner scnr = new Scanner(System.in);
      int userBase;
      int userExponent;

      userBase = scnr.nextInt();
      userExponent = scnr.nextInt();
      System.out.println(userBase + "^" + userExponent + " = "
        + raiseToPower(userBase, userExponent));
      
      System.out.println(userBase + "^" + userExponent + " = "
    	        + raiseToPower(userBase, userExponent, 0, 1));
      
      scnr.close();
   }
}