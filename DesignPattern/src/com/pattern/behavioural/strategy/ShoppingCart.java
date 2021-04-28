package com.pattern.behavioural.strategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	private final List<Item> items;

	public ShoppingCart() {
		items = new ArrayList<>();
	}

	public void additem(Item item) {
		items.add(item);
	}

	public double calctotalcost() {
		double total = 0.0;
		for (Item item : items) {
			total += item.getprice();
		}
		return total;
	}

	public boolean pay(PaymentMethod method) {
		double totalcost = calctotalcost();
		return method.pay(totalcost);
	}
}
