package lab08;

public class Encyclopedia extends Book {
	private String edition;
	private int numVolumes;
	public Encyclopedia(String title, String author, String publisher, String publicationDate, String edition,
			int numVolumes) {
		super(title, author, publisher, publicationDate);
		this.edition = edition;
		this.numVolumes = numVolumes;
	}
	public String getEdition() {
		return edition;
	}
	public int getNumVolumes() {
		return numVolumes;
	}
	
	@Override
	public String toString() {
		return "Book Information:\n\tBook Title: " + this.getTitle()
				+ "\n\tAuthor: " + this.getAuthor() + "\n\tPublisher: " + this.getPublisher()
	      + "\n\tPublication Date: " + this.getPublicationDate() + "\n\tEdition: " + this.getEdition()
	      + "\n\tNumber of Volumes: " + this.getNumVolumes();
	}
	
}