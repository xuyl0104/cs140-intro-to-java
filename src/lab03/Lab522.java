package lab03;
import java.util.Scanner; 

public class Lab522 {
    public static String describeChange (int pennies) { // "static" so it can be called from "main" 
        var output = new StringBuilder();  // Newer Java versions allow "var" for local variables in many situations
        int coins = pennies / 100;         // integer division
        String coinName = "Dollar";  
        String coinNames = "Dollars";      // this will deal with "Pennies" later on
        int remaining = pennies % 100;     // remainder of the division by 100
        if(coins > 1) {
            output.append(coins + " " + coinNames + '\n');  // '\n' is the newline character
        }                                                   // "\n" also works here,
        else if(coins > 0) {                                // in either case it is concatenated onto the String
            output.append("1 " + coinName + "\n");
        }

        coins = remaining / 25;      // Do not put "int coins"
        coinName = "Quarter";        // since "coins" was declared above
        coinNames = "Quarters";      // Similarly coinName, coinNames, remaining
        remaining = remaining % 25;  // are already declared
        if (coins > 1) {
            output.append(coins + " " + coinNames + "\n");
        }
        else if (coins > 0) {
            output.append("1 " + coinName + "\n");
        }

        coins = remaining / 10;
        coinName = "Dime";
        coinNames = "Dimes";
        remaining = remaining % 10;
        if (coins > 1) {
            output.append(coins + " " + coinNames + "\n");
        }
        else if (coins > 0) {
            output.append("1 " + coinName + "\n");
        }

        coins = remaining / 5;
        coinName = "Nickel";
        // coinNames = "Nickels";
        remaining = remaining % 5;
        if (coins > 0) {
            output.append("1 " + coinName + "\n");
        }

        coins = remaining;
        coinName = "Penny";
        coinNames = "Pennies";
        if (remaining > 1) {
            output.append(remaining + " " + coinNames + "\n");
        }
        else if (remaining > 0) {
            output.append("1 " + coinName + "\n");
        }
        // ... finish Quarters
        // and continue through Dime/Dimes, Nickel and Penny/Pennies
        // Note that you never get 2 Nickels (2 nickels = 1 dime).

        return output.toString();
    }
    public static void main(String[] args) {
        for(int i = 0; i < 300; i++) {
            System.out.println("Test " + i);
            System.out.println(describeChange(i));
        }
    }
}