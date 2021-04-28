package com.pattern.behavioural.strategy;

public class Item {
	private final String code;
	private final String name;
	private final double price;

	public Item(String code, String name, double price) {
		this.code = code;
		this.name = name;
		this.price = price;
	}

	public String getcode() {
		return code;
	}

	public String getname() {
		return name;
	}

	public double getprice() {
		return price;
	}
}