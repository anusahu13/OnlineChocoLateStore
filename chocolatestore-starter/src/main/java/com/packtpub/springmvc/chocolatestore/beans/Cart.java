/** This class maintains the products in the cart. Adding the desired product in the cart and removing unnecessary product from cart */

package com.packtpub.springmvc.chocolatestore.beans;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.packtpub.springmvc.chocolatestore.model.Product;

@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION, 
	proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {


	private Map<Product, Integer> contents = new HashMap<>();

	public Map<Product, Integer> getContents() {
		return contents;
	}
	
	public Set<Product> getProducts() {
		return contents.keySet();
	}
	
	/* To add a product in the cart */
	public void addProduct(Product product, int count) {
		
		if (contents.containsKey(product)) {
			contents.put(product, contents.get(product) + count);
		} 
		else {
			contents.put(product, count);
		}
	}
	
	/* Remove the product from the cart */
	public void removeProduct(Product product) {
		contents.remove(product);
	}
	
	/* To empty the cart */
	public void clearCart() {
		contents.clear();
	}
	
	@Override
	public String toString() {
		return contents.toString();
	}
	
	/* To calculate total added cost of the desired products */
	public double getTotalCost() {
		double totalCost = 0;
		System.out.println("Calculating Total cost:");
		for (Product product : contents.keySet()) {
			totalCost += product.getPrice();
		}
		return totalCost;
	}
	
}
