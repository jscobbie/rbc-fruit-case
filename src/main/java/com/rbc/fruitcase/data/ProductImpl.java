package com.rbc.fruitcase.data;

public class ProductImpl implements Product {

	private int itemCode;
	private String name;
	
	
	public ProductImpl(String name, int itemCode) {
		this.name = name;
		this.itemCode = itemCode;
	}
	
	@Override
	public int getItemCode() {
		return itemCode;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + itemCode;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductImpl other = (ProductImpl) obj;
		if (itemCode != other.itemCode)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
}
