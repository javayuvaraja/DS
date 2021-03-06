package com.pattern.behavioural.strategy;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class SamplePaytest {

	@Test
	public void paybillUsingVisa() {

	  ShoppingCart instance = new ShoppingCart();

	  Item a = new Item("it001","t-shirt", 750.43);
	  instance.additem(a);

	  Item b = new Item("it002","hat", 102.99);
	  instance.additem(b);

	  Date expirydate = getCardExpiryDate();
	  PaymentMethod visa = new Visa("captaindebug", "1234234534564567", expirydate);

	  boolean result = instance.pay(visa);
	  assertTrue(result);

	}

	private Date getCardExpiryDate() {
	  Calendar cal = Calendar.getInstance();
	  cal.clear();
		cal.set(2015, Calendar.JANUARY, 21);
		return cal.getTime();
	}
}