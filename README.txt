
  This is a test project.
  
  To run download and upack or clone.
  
  Then using maven in the top directory; 
  
  > mvn clean
  > mvn compile
  > mvn test
  
  To run the unit tests that exercise a solution to the Specification below.
  
  
Specification;


    "Write a program that takes a basket of items and outputs its total cost.
     The basket can contain one or more of the following items: Bananas, Oranges, Apples, Lemons, Peaches."

End Specification.


Assumptions    - 1. That Banana, Orange, Apple, Lemon, and Peach, are named products that have a monetary value.
                 2. That basket is a collection of the above items and is unlimited in size.
                 3. That cost is measured in a tradeable currency. 
                 4. That the cost of each item remains fixed irrespective of frequency or pattern of appearance.
				 5. That a product store exists and can be represented by a mocked object for an interface.
                 6. That a price list exists and can be represented by a mocked object for an interface.
				 7. That all failure condition behaviour is at the discretion of the developer. In this case
				    items with no cost will be ignored, zero or negative cost will be considered valid.
				 8. Other assumptions based upon cultural and historical factors.
				    
				    
	In fact with such a short and open specification that may actually mean something entirely different, 
 (i.e. each item is a name of a tactical manoeuvre and the cost is variable at each occurrence in the 
 strategy basket and is in a currency of people's lives). 
 
     So is the test really that we make the same assumptions as the neurotypicals ?, or that we did not use
 a Spring container. 
 
     
 