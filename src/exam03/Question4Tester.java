package exam03;

public class Question4Tester {
	public static void main(String[] args) {
		String[] pNames = {"Lettuce", "Tomato", "Rice", "Beans", "Soap",
				"Saucepan", "Knife", "Fork", "Plate", "Cup"};
		ProductType[] pTypes = new ProductType[pNames.length];
		for(int i = 0; i < pNames.length; i++) {
			pTypes[i] = new ProductType(pNames[i]);
			pTypes[i].replenish(100+10*i);
		}
		ArrayStorage array = new ArrayStorage();
		System.out.println("CHECKING addProductType");
		for(int i = pNames.length - 1; i >= 0; i--) {
			array.addProductType(pTypes[i]);
		}
		for(int i = 0; i < pNames.length; i++) {
			System.out.println(array.getStorage()[i].getId() + 
					" should be " + pTypes[9 - i].getId());
		}
		System.out.println("CHECKING find");
		ProductType p = array.find(3);
		System.out.println(p.getId() + " should be 3");
		System.out.println(p.getDescription() + " should be Rice");
		p = array.find(0);
		System.out.println(p + " should be null");
		p = array.find(11);
		System.out.println(p + " should be null");
	}
}
