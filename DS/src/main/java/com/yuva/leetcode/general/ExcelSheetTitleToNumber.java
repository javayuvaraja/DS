package com.yuva.leetcode.general;

/**
 * 171. Excel Sheet Column Number

Given a string columnTitle that represents the column title as appear in an Excel sheet, return its corresponding column number.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 

Example 1:

Input: columnTitle = "A"
Output: 1
Example 2:

Input: columnTitle = "AB"
Output: 28
Example 3:

Input: columnTitle = "ZY"
Output: 701
Example 4:

Input: columnTitle = "FXSHRXW"
Output: 2147483647
 * @author Yuvaraja Kanagarajan
 *
 */
public class ExcelSheetTitleToNumber {

	public int titleToNumber(String s) {
        char []charArr = s.toCharArray();
        int value = 0;
        int multiply = 1;
        for (int i =charArr.length-1; i >=0; i-- ) {
            int currValue = (charArr[i]-'A')+1;
            System.out.println(currValue);
            value += currValue*multiply ;
            multiply = multiply * 26;
        }
        
        return value;
    }
	
	public String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        while(n>0){
            char temp = (char)((n%26==0?26:n%26)+64);
            sb.append(temp);
            n =(n%26==0? n/26-1: n/26);
        }
        return sb.reverse().toString();
    }
}
