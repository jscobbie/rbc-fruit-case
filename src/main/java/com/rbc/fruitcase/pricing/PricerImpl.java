package com.rbc.fruitcase.pricing;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.rbc.fruitcase.data.Basket;
import com.rbc.fruitcase.data.Product;

public class PricerImpl implements Pricer{
	
	private PriceList priceList;
	
	
	public PricerImpl(PriceList priceList) {
		this.priceList = priceList;
	}
	
	
	public Cost getTotalCostFromBasket(Basket basket) {
		Cost totalCost = Cost.ZERO_COST;
		
		if ((basket != null) && (basket.getContents() != null) && (!basket.getContents().isEmpty())) {
			
		    List<Product> values = basket.getContents();
		    
		    // These can be chained as one, I leave them with intermediate stages for clarity.
		    List<Integer> itemsList = values.stream().mapToInt(Product::getItemCode).boxed().collect(Collectors.toList());
		    List<BigDecimal> costList = itemsList.stream().map(priceList::getPrice).collect(Collectors.toList());  
		    Optional<BigDecimal> result =  costList.stream().reduce((x, y) -> x.add(y));            
            
		    if (result.isPresent()) {
	            totalCost = new Cost(result.get(),priceList.getCurrency());
	        }
		}
		return totalCost;
	}

}
