package com.yuva.leetcode.string;

public class RotationalCipher {

	static String rotationalCipher(String input, int rotationFactor) {
	    StringBuilder result = new StringBuilder(input.length());
	    for (char character : input.toCharArray()) {
	        if (character != ' ') {
	            int originalAlphabetPosition = character - 'a';
	            int newAlphabetPosition = (originalAlphabetPosition + rotationFactor) % 26;
	            char newCharacter = (char) ('a' + newAlphabetPosition);
	            result.append(newCharacter);
	        } else {
	            result.append(character);
	        }
	    }
	    return result.toString();
	}
	
	public static StringBuffer encrypt(String input, int s)
    {
        StringBuffer result= new StringBuffer();
 
        for (int i=0; i<input.length(); i++)
        {
        	char currChar = input.charAt(i);
        	if (!Character.isLetterOrDigit(currChar)) {
        		result.append(currChar);
        	} else if (Character.isDigit(currChar)) {
        		int newChar = ((int)currChar + (s % 10)) ;
        		if (newChar > 57) {
        			newChar = newChar-10;
        		}
        		result.append((char)newChar);
        	} else if (Character.isUpperCase(currChar))  {
        		char ch = (char)(((int) currChar + s - 65) % 26 + 65);
                result.append(ch);
            }else {
                char ch = (char)(((int) currChar + s - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }
	
	public static void main(String[] args) {
		String str = "Zebra-493?";
		System.out.println(encrypt(str, 3));
	}
}
