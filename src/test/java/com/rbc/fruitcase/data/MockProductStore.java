package com.rbc.fruitcase.data;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Can we really Mock something that has no real counterpart
 * 
 * Check with Aristotle's Theory of Forms and Lewis Carroll
 *
 */
public class MockProductStore implements ProductStore {

	
	private Map<String,Product> productByName = new HashMap<>();
	
	private Map<Integer,Product> productByItemCode = new HashMap<>();
	
	
	public MockProductStore() {
		Product apple = new ProductImpl("Apple",332286);
		Product banana = new ProductImpl("Banana",7430790);
		Product lemon = new ProductImpl("Lemon",93);
		Product orange = new ProductImpl("Orange",79);
		Product peach = new ProductImpl("Peach",2523);
		
		productByName.put(apple.getName(), apple);
		productByName.put(banana.getName(), banana);
		productByName.put(lemon.getName(), lemon);
		productByName.put(orange.getName(), orange);
		productByName.put(peach.getName(), peach);

		productByItemCode.put(apple.getItemCode(), apple);
		productByItemCode.put(banana.getItemCode(), banana);
		productByItemCode.put(lemon.getItemCode(), lemon);
		productByItemCode.put(orange.getItemCode(), orange);
		productByItemCode.put(peach.getItemCode(), peach);
		
	}
	
	
	@Override
	public Product getProductByName(String name) {
        return productByName.get(name);
	}

	@Override
	public Product getProductByItemCode(int itemCode) {
        return productByItemCode.get(itemCode);
	}

	public Product getRandomProduct(int value) {
		if ((value % 5) == 0) return productByName.get("Apple");
		if ((value % 5) == 1) return productByName.get("Banana");
		if ((value % 5) == 2) return productByName.get("Lemon");
		if ((value % 5) == 3) return productByName.get("Orange");
		return productByName.get("Peach");
	}

	
}
