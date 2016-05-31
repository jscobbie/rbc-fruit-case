package com.rbc.fruitcase.pricing;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * 
 * Can we really Mock something that has no real counterpart
 * 
 * Check with Aristotle's Theory of Forms and Lewis Carroll
 *
 */
public class MockPriceList implements PriceList {
	
	private static PriceList priceList = new MockPriceList();
	
	private Map<Integer,BigDecimal> prices = new HashMap<>();
	private Currency currency = null; 

	
	private MockPriceList() {
		init();
	}
	
	// Load the price from test resources list or fail gracefully.
	private void init() {
		
		// Get Currency from Locale
		Locale currentLocale = Locale.getDefault();
		currency = Currency.getInstance(currentLocale);
		
		prices.clear();
		
		try {
			
		ResourceBundle priceResources = ResourceBundle.getBundle("prices");
		 for (String key : priceResources.keySet()) {
		    try {
           	    int itemCode = Integer.parseInt(key);
           	    String priceString = priceResources.getString(key);
           	    prices.put(itemCode, new BigDecimal(priceString));              	 
            } catch (NumberFormatException nfe) {
           	    System.out.println("Unable to load price for product ["+key+"]");
            }
		 }
		
		} catch (Throwable t) {
			System.out.println("Price List has failed to load from properties bundle [prices] for Locale [" + currentLocale + "]");
			System.exit(0);
		}
       
	}
	
	public static PriceList getPriceList() {
		return priceList;
	}
	
	public BigDecimal getPrice(Integer itemCode) {
		if (prices.containsKey(itemCode)) {
			return prices.get(itemCode);
		}
		System.out.println("Price not found for item [" +itemCode+ "]");
		return BigDecimal.ZERO;
	}

	public Currency getCurrency() {
		return currency;
	}
	
	public void reinit() {
		init();
	}

}
