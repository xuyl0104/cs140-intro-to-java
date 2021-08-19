package exam03;

import java.util.List;
import java.util.ArrayList;

public class ListStorage extends Storage {
	private List<ProductType> storage = new ArrayList<>();

	public List<ProductType> getStorage() {
		return storage;
	}

	public void setStorage(List<ProductType> storage) {
		this.storage = storage;
	}

	@Override
	public ProductType find(int id) {
		// TODO Auto-generated method stub
		ProductType resProductType = null;
		for (int i = 0; i < storage.size(); ++i) {
			if (storage.get(i).getId() == id) {
				resProductType = storage.get(i);
				break;
			}
		}
		return resProductType;
	}

	@Override
	public void addProductType(ProductType p) {
		// TODO Auto-generated method stub
		storage.add(p);
	}
	
	
}
