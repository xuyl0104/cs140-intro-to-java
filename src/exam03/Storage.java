package exam03;

public abstract class Storage {
	/**
	 * Returns the ProductType object with the given id or null if
	 * no ProductType has that id.
	 * @param id the id of the ProductType requested
	 * @return the ProductType for this id or null if there is none
	 */
	public abstract ProductType find(int id);

	/**
	 * Add this ProductType to the Storage
	 * @param p a new ProductType.
	 */
	public abstract void addProductType(ProductType p);

	public String buy(int id, int quantity) {
		ProductType type = find(id);
		if (type == null) {
			return "Sorry we do not have any of that type of product";
		}
		if (quantity <= 0) {
			return "Quantity " + quantity + " is not valid";
		}
		int quantityOnHand = type.amountOnHand();
		if (quantityOnHand < quantity) {
			return "Sorry we do not have a sufficient quantity of " + type.getDescription();
		}
		type.purchase(quantity);
		return " We will send you " + quantity + " of " + type.getDescription();
	}

	public String addQuantity(int id, int quantity) {
		ProductType type = find(id);
		if (type == null) {
			return "Sorry we do not have any of that type of product";
		}
		if (quantity <= 0) {
			return "Quantity " + quantity + " is not valid";
		}
		type.replenish(quantity);
		return "Added " + quantity + " of " + type.getDescription();
	}
}
