package assignment03;

public class Book {
	private String title;
	private String author;
	private String publisher;
	private String publicationDate;
	public Book(String title, String author, String publisher, String publicationDate) {
		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.publicationDate = publicationDate;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getPublisher() {
		return publisher;
	}
	public String getPublicationDate() {
		return publicationDate;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	@Override
	public String toString() {
		return "Book Information:\n\tBook Title: " + title
			+ "\n\tAuthor: " + author + "\n\tPublisher: " + publisher
      + "\n\tPublication Date: " + publicationDate;
	}
}