package com.udhaya.learning.collection;

public class Country {

	String id;
	String name;
	
	public Country (String countryId, String countryName){
		this.id = countryId;
		this.name = countryName;
	}

	public String getId() {
		return id;
	}

	public void setId(String countryId) {
		this.id = countryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String countryName) {
		this.name = countryName;
	}
	
	
}
