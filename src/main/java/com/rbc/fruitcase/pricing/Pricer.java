package com.rbc.fruitcase.pricing;

import com.rbc.fruitcase.data.Basket;

public interface Pricer {

	public Cost getTotalCostFromBasket(Basket basket);
}
