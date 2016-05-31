package com.rbc.fruitcase.pricing;

import java.math.BigDecimal;
import java.util.Currency;

public interface PriceList {
	
	public BigDecimal getPrice(Integer itemCode);

	public Currency getCurrency();
	

}
