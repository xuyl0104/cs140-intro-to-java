package assignment04;
import java.util.Scanner;
import java.util.ArrayList;

public class PhotoLineups {

   // TODO: Write method to create and output all permutations of the list of names.
   public static void allPermutations(ArrayList<String> permList, ArrayList<String> nameList) {
      if (nameList.size() == 0) {
         // all the names are in the list and print
         printPermList(permList);
      }
      else {
         for (int i = 0; i < nameList.size(); ++i) {
        	String temp = nameList.get(i);
            permList.add(nameList.get(i));
            nameList.remove(nameList.get(i));
            allPermutations(permList, nameList);
            permList.remove(permList.size() - 1);
            nameList.add(i, temp);
         }
      }
   }
   
   public static void printPermList(ArrayList<String> permList) {
      for (String name : permList) {
         System.out.print(name + " ");
      }   
      System.out.println("");
   }

   public static void main(String[] args) {
      Scanner scnr = new Scanner("Julia Lucas Mia -1");
      ArrayList<String> nameList = new ArrayList<String>();
      ArrayList<String> permList = new ArrayList<String>();
      String name;
      
      // TODO: Read in a list of names; stop when -1 is read. Then call recursive method.
      name = scnr.next();
      while (!name.equals("-1")) {
         nameList.add(name);
         name = scnr.next();
      }
      allPermutations(permList, nameList);
   }
}
