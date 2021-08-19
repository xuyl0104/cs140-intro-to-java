package exam03;

public class ProductType {
	private int quantity = 1;
	private String description;
	private static int nextID = 1;
	private int id;
	
	public ProductType(String descriptionVal) {
		description = descriptionVal;
		id = nextID++;
	}
	
	public void replenish(int n) {
		quantity += n;
	}
	
	public int amountOnHand() {
		return quantity;
	}

	public String getDescription() {
		return description;
	}

	public int getId() {
		return id;
	}
	
	static void resetID() {
		nextID = 1;
	}
	
	public void purchase(int n) throws IllegalArgumentException {
		if (n > quantity) {
			throw new IllegalArgumentException("not enough product on hand");
		}
		quantity -= n;
	}
}
