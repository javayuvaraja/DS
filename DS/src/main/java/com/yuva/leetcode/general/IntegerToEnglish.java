 package com.yuva.leetcode.general;
   
public class IntegerToEnglish {

	private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
	
	
	public String numberToWords(int number) {
		if (number == 0 ) {
			return "Zero";
		}
		
		int i = 0;
		String result = "";
		while (number > 0) {
			if (number%1000 != 0) {
				result = getString(number%1000) + THOUSANDS[i] + " " + result;
			}
			i++;
			number = number/1000;
		}
		return result.trim();
	}
	
	private String getString(int number) {
		if (number == 0) {
			return "";
		}
		if (number < 20) {
			return LESS_THAN_20[number] + " ";
		} else if (number < 100) {
			return TENS[number/10] +  " " + getString(number%10);
		} else {
			return LESS_THAN_20[number/100] + " Hundred " + getString(number%100);
		}
	}
	
	public static void main(String[] args) {
		IntegerToEnglish obj =  new IntegerToEnglish();
		System.out.println(obj.numberToWords(112320));
	}
}
