package com.rbc.fruitcase.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Basket {

	private List<Product> contents = new ArrayList<>();
	
	public void addItem(Product item) {
		contents.add(item);
	}
	
	public void removeItem(Product item) {
		contents.remove(item);
	}
	
	public void empty() {
		contents.clear();
	}
	
	public List<Product> getContents() { 
		return new ArrayList<Product>(contents);
	} 
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Basket [");
		sb.append(contents.stream().map(p  -> p.getName()).collect(Collectors.joining(", ")));
		sb.append("]");
		return sb.toString();
	}
	
}
