package exam03;

public class Question1Tester {

	public static void main(String[] args) {
		String[] pNames = {"Lettuce", "Tomato", "Rice", "Beans", "Soap",
				"Saucepan", "Knife", "Fork", "Plate", "Cup"};
		ProductType[] pTypes = new ProductType[pNames.length];
		for(int i = 0; i < pNames.length; i++) {
			pTypes[i] = new ProductType(pNames[i]);
		}
		System.out.println("Checking ids");
		for(int i = 0; i < pNames.length; i++) {
			System.out.println(pTypes[i].getId() + " should be " + (i+1));
		}		
		System.out.println("Checking descriptions");
		for(int i = 0; i < pNames.length; i++) {
			System.out.println(pTypes[i].getDescription() + " should be " + pNames[i]);
		}		
		System.out.println("Checking amountOnHand");
		for(int i = 0; i < pNames.length; i++) {
			System.out.println(pTypes[i].amountOnHand() + " should be " + 1);
		}		
		System.out.println("Checking replenish");
		for(int i = 0; i < pNames.length; i++) {
			pTypes[i].replenish(100+10*i);
			System.out.println(pTypes[i].amountOnHand() + " should be " + (100+10*i+1));
		}		
		System.out.println("Checking purchase");
		for(int i = 0; i < pNames.length; i++) {
			if(i < pNames.length - 1) {
				pTypes[i].purchase(40+5*i);
				System.out.println(pTypes[i].amountOnHand() + " should be " + (60+5*i+1));
			} else {
				try {
					pTypes[i].purchase(200);
					System.out.println("YOUR EXCEPTION CODE FAILED");
				} catch (IllegalArgumentException e) {
					System.out.println("Exception message check");
					System.out.println("\"" + e.getMessage() + "\" should be \"not enough product on hand\"");
					System.out.println(pTypes[i].amountOnHand() + " should be " + (100+10*i+1));
				}
			}
		}		
		System.out.println("Checking resetID");
		ProductType.resetID();
		ProductType p = new ProductType("Test");
		System.out.println(p.getId() + " should be 1");
	}

}
