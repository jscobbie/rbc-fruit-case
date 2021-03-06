package com.rbc.fruitcase.test;


import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rbc.fruitcase.data.Basket;
import com.rbc.fruitcase.data.MockProductStore;
import com.rbc.fruitcase.data.Product;
import com.rbc.fruitcase.pricing.Cost;
import com.rbc.fruitcase.pricing.MockPriceList;
import com.rbc.fruitcase.pricing.Pricer;
import com.rbc.fruitcase.pricing.PricerImpl;

public class TestBasketPricer {

	   private Basket basket = new Basket();
	   private Pricer pricer = null;
	   private MockProductStore productStore = null;
	   private Locale testLocale = Locale.UK;
       private Random rand = new Random(System.currentTimeMillis());
	   
	   
		@Before
		public void setUp() throws Exception {
			productStore = new MockProductStore();
			Locale.setDefault(Locale.UK);        	
        	pricer = new PricerImpl(MockPriceList.getPriceList());
		}

		@After
		public void tearDown() throws Exception {
		}
		
		@Test
		public void testNoBasketCost() {
			Cost cost = pricer.getTotalCostFromBasket(null);
			System.out.println("For " + basket);
			System.out.println(cost);
			assertEquals(cost.getValue(), BigDecimal.ZERO);
			assertEquals(cost.getCurrency(), Currency.getInstance(testLocale));
		}

		@Test
		public void testEmptyBasketCost() {
			basket.empty();
			Cost cost = pricer.getTotalCostFromBasket(basket);
			
			System.out.println("For " + basket);
			System.out.println(cost);
			
			assertEquals(cost.getValue(), BigDecimal.ZERO);
			assertEquals(cost.getCurrency(), Currency.getInstance(testLocale));
		}
		
		@Test
		public void testSingleItemBasketCost() {
			Product apple = productStore.getProductByName("Apple");
			basket.addItem(apple);
			Pricer pricer = new PricerImpl(MockPriceList.getPriceList());
			Cost cost = pricer.getTotalCostFromBasket(basket);
			
			System.out.println("For " + basket);
			System.out.println(cost);
			
			assertEquals(cost.getValue(), MockPriceList.getPriceList().getPrice(apple.getItemCode()));
			assertEquals(cost.getCurrency(), Currency.getInstance(testLocale));
		}
		
		@Test
		public void testRandomBasketCost() {
			BigDecimal randomTargetPrice = generateRandomBasket();
			Cost cost = pricer.getTotalCostFromBasket(basket);
			
			System.out.println("For " + basket);
			System.out.println(cost);
			
			assertEquals(cost.getValue(), randomTargetPrice);
			assertEquals(cost.getCurrency(), Currency.getInstance(testLocale));
		}
		

     
        
        private BigDecimal generateRandomBasket() {
        	basket.empty();
        	BigDecimal randomTargetPrice = new BigDecimal("0.00");
        	int basketSize = rand.nextInt(25) + 6;
        	for (int i = 0; i < basketSize; i++) {
        		Product p = productStore.getRandomProduct(rand.nextInt(5));
        		basket.addItem(p);
        		randomTargetPrice = randomTargetPrice.add(MockPriceList.getPriceList().getPrice(p.getItemCode()));
        	}
        	
        	return randomTargetPrice;
        }
		
}
