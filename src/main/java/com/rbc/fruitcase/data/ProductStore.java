package com.rbc.fruitcase.data;

public interface ProductStore {

	public Product getProductByName(String name);
	
	public Product getProductByItemCode(int itemCode);
		
}
