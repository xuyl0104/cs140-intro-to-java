package assignment03;
import java.util.Scanner;

public class BookInformation {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      Book myBook = null;
      Encyclopedia myEncyclopedia = null;

      String title, author, publisher, publicationDate;
      String eTitle, eAuthor, ePublisher, ePublicationDate, edition;
      int numVolumes;

      System.out.print("Book title: ");
			title = scnr.nextLine();
      System.out.print("Book author: ");
      author = scnr.nextLine(); 
      System.out.print("Book publisher: ");
      publisher = scnr.nextLine(); 
      System.out.print("Book publication date: ");
      publicationDate = scnr.nextLine();

      System.out.print("Encyclopedia title: ");
      eTitle = scnr.nextLine();
      System.out.print("Encyclopedia author: ");
      eAuthor = scnr.nextLine();
      System.out.print("Encyclopedia publisher: ");
      ePublisher = scnr.nextLine();
      System.out.print("Encyclopedia publication date: ");
      ePublicationDate = scnr.nextLine();
      System.out.print("Encyclopedia edition: ");
      edition = scnr.nextLine();
      System.out.print("Encyclopedia num volumes: ");
      numVolumes = scnr.nextInt();

      myBook = new Book(title, author, publisher, publicationDate);
      System.out.println(myBook);

      myEncyclopedia = new Encyclopedia(eTitle, eAuthor,
            ePublisher, ePublicationDate, edition, numVolumes);
      System.out.println(myEncyclopedia);
      
      scnr.close();
    }
}