package com.yuva.amazon.oa;

import java.security.DomainCombiner;

public class LexiographicalSmallestString {

	/*
	function minString(s) {
	    let letters = "abcdefghijklmnopqrstuvwxyz";
	    let res = "";
	    s += "<"; // add a stub 
	    for (let i = 0; i < s.length; i++) {
	        if (s[i] === "<") {
	            res += letters[i];
	        } else {
	            let start = i;
	            while (s[i] === ">") i++;
	            for (let j = i; j >= start; j--) {
	                res += letters[j]; // descending series of letters
	            }
	        }
	    }
	    return res;
	}
	*/
	
	public static void main(String[] args) {
		String str = "><";
		System.out.println(findMinString(str));
	}
	
	public static String findMinString(String input) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		StringBuffer result = new StringBuffer();
		
		input = input+'<';
		for (int i=0; i < input.length(); i++) {
			if (input.charAt(i) == '<') {
				result.append(alphabet.charAt(i));
			} else {
				int startIndex = i;
				while (i < input.length() && input.charAt(i) == '>') {
					i++;
				}
				
				for (int j=i; j >=startIndex; j--) {
					result.append(alphabet.charAt(j));
				}
			}
		}
		return result.toString();
	}
	
}
