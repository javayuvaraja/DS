package com.yuva.leetcode.general;

import java.util.HashMap;
import java.util.Map;


/**
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer 
 * 
The algorithm for myAtoi(string s) is as follows:

Read in and ignore any leading whitespace.
Check if the next character (if not already at the end of the string) is '-' or '+'. 
Read this character in if it is either. This determines if the final result is negative or positive respectively. 
Assume the result is positive if neither is present.
Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. 
Change the sign as necessary (from step 2).
If the integer is out of the 32-bit signed integer range [-231, 231 - 1],
 then clamp the integer so that it remains in the range. Specifically, 
integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
Return the integer as the final result.

 * @author Yuvaraja Kanagarajan
 *
 */
public class Atoi {

	static Map<Character, Integer> charMap = new HashMap<>();
    static {
        charMap.put('1',1);
        charMap.put('2',2);
        charMap.put('3',3);
        charMap.put('4',4);
        charMap.put('5',5);
        charMap.put('6',6);
        charMap.put('7',7);
        charMap.put('8',8);
        charMap.put('9',9);
        charMap.put('0',0);
    }

    public static int myAtoi(String str) {
        if (str.isEmpty()|| str.trim().isEmpty()){
            return 0;
        }
        str = str.trim();
        char[] charArr = str.toCharArray();
        boolean isNegative = str.indexOf("-")==0;
        boolean isPlusSign = str.indexOf("+")==0;
        if ((isNegative||isPlusSign) && charArr.length==1){
            return 0;
        }
        int index = isNegative || isPlusSign ? 1 :0;
        if(!isNegative && !charMap.containsKey(charArr[index])) {
            return 0;
        }

        long number = 0;

        for (; index < charArr.length; index++) {
            if (charMap.containsKey(charArr[index]) && (number <=Integer.MAX_VALUE)) {
                int temp = charMap.get(charArr[index]);
                number = (number*10) +temp;
            } else {
                break;
            }
        }
        int result =0;
        if (number > Integer.MAX_VALUE) {
            if (isNegative) {
                result =  Integer.MIN_VALUE;
            } else {
                result = Integer.MAX_VALUE;
              }           
        } else {
            result = (int) number;
        }

        return result>0 && isNegative ? -result : result;
    }
}
