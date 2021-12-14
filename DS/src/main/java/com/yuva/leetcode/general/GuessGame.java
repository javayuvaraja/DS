package com.yuva.leetcode.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Wayfair
 
You need to guess a word . The word will be there in a master list .

You are provided with a list of Words and number of character match at the right position .

Example 
input {{"MOXTE",3} , {"AXCDG",0},{"MOQRT",2},{"FOUSE",4},{"POWER",1}

return  "MOUSE"    
 * @author Yuvaraja Kanagarajan
 *
 */
public class GuessGame {

	/**
	 * calculate the weight (number of character match) of each character in every position 
	 * and choose the one which has maximum weight.
			From the example, let's say there is an array that has a length is 5.
			In the first position, {'M': 2 + 3 = 5, 'A': 0, 'F': 4, 'P':1} --> M
			Second one: {'O': 3 + 2 + 4 + 1 = 10, 'X': 0}-->O
			Third one: {'X': 3, 'C': 0, 'Q': 2, 'U': 4, 'W': 1} -->U
			Fourth one: {'T': 3, 'D': 0, 'R':2, 'S':4, 'E':1 }-->S
			Last one: {'E':3 + 4 + 1 = 8, 'G':0, 'T': 2, 'R': 1}-->E
	 */
	
	public static void main(String[] args) {
		Pair pair = new Pair("MOXTE", 3);
		Pair pair1 = new Pair("MOQRT",2);
		Pair pair2 = new Pair("FOUSE",4);
		Pair pair3 = new Pair("POWER",1);
		
		List<Pair> pairList =  new ArrayList<>();
		pairList.add(pair);
		pairList.add(pair1);
		pairList.add(pair2);
		pairList.add(pair3);
		
		System.out.println(guessWord(pairList));
	}
	
	static class Pair {
		private String word;
		private int count;
		public Pair (String word, int count) {
			this.word = word;
			this.count = count;
		}
	}
	
	private static String guessWord (List<Pair> wordsList) {
		Map<Integer, Map<Character, Integer>> weightMap = new LinkedHashMap<>();
		
		int wordLen = wordsList.get(0).word.length();
		
		for (int i=0; i < wordLen; i++) {
			weightMap.put(i, new HashMap<Character, Integer>());
		}
		for (Pair pair : wordsList) {
			String word = pair.word;
			int weight = pair.count;
			for (int i=0; i < wordLen; i++) {
				Map<Character, Integer> charMap = weightMap.get(i);
				int charWeight = charMap.getOrDefault(word.charAt(i), 0) + weight;
				charMap.put(word.charAt(i), charWeight);
			}
		}
		
		StringBuffer result = new StringBuffer();
		for (Integer index : weightMap.keySet()) {
			Map<Character, Integer> charMap = weightMap.get(index);
			int max = 0;
			char posChar=' ';
			for (Character ch : charMap.keySet()) {
				if (max < charMap.get(ch)) {
					posChar = ch;
					max = charMap.get(ch);
				}
			}
			result.append(posChar);
			
		}
		
		return result.toString();
		
	}
	
}
