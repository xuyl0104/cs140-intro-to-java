package assignment03;

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
		return super.toString() + "\n\tEdition: " + this.getEdition()
	      + "\n\tNumber of Volumes: " + this.getNumVolumes();
	}
	
}