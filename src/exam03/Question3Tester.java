package exam03;

public class Question3Tester {
	public static void main(String[] args) {
		String[] pNames = {"Lettuce", "Tomato", "Rice", "Beans", "Soap",
				"Saucepan", "Knife", "Fork", "Plate", "Cup"};
		ProductType[] pTypes = new ProductType[pNames.length];
		for(int i = 0; i < pNames.length; i++) {
			pTypes[i] = new ProductType(pNames[i]);
			pTypes[i].replenish(100+10*i);
		}
		ListStorage list = new ListStorage();
		System.out.println("CHECKING addProductType");
		for(int i = pNames.length - 1; i >= 0; i--) {
			list.addProductType(pTypes[i]);
		}
		for(int i = 0; i < pNames.length; i++) {
			System.out.println(list.getStorage().get(i).getId() + 
					" should be " + pTypes[9 - i].getId());
		}
		System.out.println("CHECKING find");
		ProductType p = list.find(3);
		System.out.println(p.getId() + " should be 3");
		System.out.println(p.getDescription() + " should be Rice");
		p = list.find(0);
		System.out.println(p + " should be null");
		p = list.find(11);
		System.out.println(p + " should be null");
		System.out.println("CHECKING addQuantity IN Storage");
		p = list.find(3);
		String s = list.addQuantity(3, 11);
		System.out.println(p.amountOnHand() + " should be 132");
		System.out.println("\"" + s + "\" should be \"Added 11 of Rice\"");
		s = list.addQuantity(3, -1);
		System.out.println(p.amountOnHand() + " should be 132");
		System.out.println("\"" + s + "\" should be \"Quantity -1 is not valid\"");
		s = list.addQuantity(11, 1);
		System.out.println("\"" + s + "\" should be \"Sorry we do not have any of that type of product\"");
		System.out.println("CHECKING buy IN Storage");
		p = list.find(3);
		s = list.buy(3, 11);
		System.out.println(p.amountOnHand() + " should be 121");
		System.out.println("\"" + s + "\" \"We will send you 11 of Rice\"");
		s = list.buy(3, -1);
		System.out.println(p.amountOnHand() + " should be 121");
		System.out.println("\"" + s + "\" should be \"Quantity -1 is not valid\"");
		s = list.buy(3, 200);
		System.out.println(p.amountOnHand() + " should be 121");
		System.out.println("\"" + s + "\" should be \"Sorry we do not have a sufficient quantity of Rice\"");
		s = list.addQuantity(11, 1);
		System.out.println("\"" + s + "\" should be \"Sorry we do not have any of that type of product\"");
	}
}
