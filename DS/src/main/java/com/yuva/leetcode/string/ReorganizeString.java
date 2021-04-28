package com.yuva.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S, check if the letters can be rearranged so that two characters that 
 * are adjacent to each other are not the same.

   If possible, output any possible result.  If not possible, return the empty string.
 * @author Yuvaraja Kanagarajan
 *
 */
public class ReorganizeString {

	public String reorganizeString1(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int max = 0;
        char letter = 0;
        char chArr[]= str.toCharArray();
        for (char ch: chArr) {
        	freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
        	if (freqMap.get(ch) > max) {
        		max = freqMap.get(ch);
        		letter = ch;
        	}
        }
        
        if (max > (str.length() + 1) / 2) {
            return ""; 
        }
        
        char[] res = new char[str.length()];
        int idx = 0;
        while (max > 0) {
            res[idx] = letter;
            idx += 2;
            max--;
        }
        freqMap.remove(letter);
        for(char ch: freqMap.keySet()) {
        	int frequency = freqMap.get(ch);
        	while (frequency>0) {
        		if (idx >= res.length) {
                    idx = 1;
                }
        		res[idx] = ch;
        		idx += 2;
        		frequency--;
        	}
        }
        return String.valueOf(res);
    }
	
	public static void main(String[] args) {
		ReorganizeString obj = new ReorganizeString();
		System.out.println(obj.reorganizeString1("aab"));
	}
	
}
