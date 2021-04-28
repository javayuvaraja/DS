package com.yuva.leetcode.general;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class IntegerToRoman {

	static Map<Integer,String> charMap = new LinkedHashMap<>();
	static {
		charMap.put(1000, "M");
		charMap.put(900, "CM");
		charMap.put(500, "D");
		charMap.put(400, "CD");
		charMap.put(100, "C");
		charMap.put(90, "XC");
		charMap.put(50, "L");
		charMap.put(40, "XL");
		charMap.put(10, "X");
		charMap.put(9, "IX");
		charMap.put(5, "V");
		charMap.put(4, "IV");
		charMap.put(1, "I");		
	}
	
	public String intToRoman(int num) {
		if (num == 0 ) {
			return "";
		}
		
		Iterator<Entry<Integer, String>> itr = charMap.entrySet().iterator();
		StringBuffer strBuff = new StringBuffer();
		while (itr.hasNext() && num >0) {
			Entry<Integer, String> entry = itr.next();
			int temp = num/entry.getKey();
			while (temp>0) {
				strBuff.append(entry.getValue());
				temp--;
			}
			num = num%entry.getKey();
		}
		
		return strBuff.toString();
	}
}
