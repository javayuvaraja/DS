package com.udhaya.learning.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {

	Map<String, String> countryMap = new HashMap<>();
	public static void main(String[] args) {
	
		Country country =  new Country("IND", "India");
		Country country1 =  new Country("AUS", "Australia");
		Country country2 =  new Country("SA", "South Africa");
		Country country3 =  new Country("USA", "America");
		List<Country> countryList = new ArrayList<>();
		countryList.add(country1);
		countryList.add(country2);
		countryList.add(country3);
		countryList.add(country);
		
		MapTest obj = new MapTest();
		obj.storeCountries(countryList);
		
		System.out.println(obj.getCountryName("ind"));
		System.out.println(obj.getCountryName("AUS"));
		obj.displayCountries(obj.countryMap);
		
		
	}
	
	public void displayCountries(Map<String, String> map) {
		Set<String> set = map.keySet();
		for (String key : set) {
			String value = map.get(key);
			System.out.println("key :" + key + " value :" + value);
		}
		
		for (Entry<String, String> entry : map.entrySet()) {
			System.out.println("key :" + entry.getKey() + " value :" + entry.getValue());
		}
	}
	public String getCountryName (String countryId) {
		countryId = countryId.toUpperCase();
		if (countryMap.containsKey(countryId)) {
			
			return countryMap.get(countryId);
		}
		
		return "Not available";
	}
	
	
	public void storeCountries(List<Country> countries) {
		for (Country country: countries) {
			countryMap.put(country.getId(), country.getName());
		}
	}
	
}
