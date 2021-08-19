package exam03;

import java.util.Arrays;

public class ArrayStorage extends Storage{
	private ProductType[] storage = new ProductType[5];
	private int nextIndex = 0;
	
	public ProductType[] getStorage() {
		return storage;
	}
	public void setStorage(ProductType[] storage) {
		this.storage = storage;
	}
	
	@Override
	public ProductType find(int id) {
		ProductType resProductType = null;
		for (int i = 0; i < storage.length; ++i) {
			if (storage[i].getId() == id) {
				resProductType = storage[i];
				break;
			}
		}
		return resProductType;
	}
	@Override
	public void addProductType(ProductType p) {
		if (nextIndex == storage.length) {
			storage = Arrays.copyOf(storage, 2*storage.length);
		}
		storage[nextIndex++] = p;
	}
	
	
}
