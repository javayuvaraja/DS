package com.yuva.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Bloomberg question
Given the welsh alphabet a b c ch d dd e f ff g ng h i j l ll m n o p ph r rh s t th u w y and a list of strings, 
how would you sort the strings according to that alphabet?
(Rules are that double letter character preceeds single letter character, 
eg. if a word contains "ng", it corresponds to the character "ng", not to "n" and "g").


 * @author Yuvaraja Kanagarajan
 *
 */
public class WelshDictionarySorting {

	public static void main(String[] args) {
		WelshDictionarySorting welshDictionary = new WelshDictionarySorting();
		String[] words = new String[] { "che", "abcd", "abcdd", "addcb" };
		welshDictionary.WelshDictionarySort(words);
		for (String word : words)
			System.out.println(word);
	}

	public String[] WelshDictionarySort(String[] words) {
		String[] alphabets = new String[] { "a", "b", "c", "ch", "dd", "d", "e", "f", "ff", "g", "ng", "h", "i", "j",
				"l", "ll", "m", "n", "o", "p", "ph", "r", "rh", "s", "t", "th", "u", "w", "y" };

		HashMap<String, Integer> welshMap = new HashMap<>();
		
		for (int i = 0; i < alphabets.length; i++) {
			welshMap.put(alphabets[i], i); // storing the character(s) with the index
		}

		Arrays.sort(words, (word1, word2) -> {
			int length1 = word1.length();
			int length2 = word2.length();
			int i = 0;
			int j = 0;

			while (i < length1 && j < length2) {

				String firstCharacterWord1 = word1.charAt(i) + "";
				String firstCharacterWord2 = word2.charAt(j) + "";

				if (i < length1 - 1 && welshMap.containsKey(word1.substring(i, i + 2))) { // checking the map whether two character letter is there 
																						  // in the welsh dictionary
					firstCharacterWord1 = word1.substring(i, i + 2); // if it is there then take both the letter
					i++; // incrementing here because two index movement is required for this case. the other one is in common
				}
				if (j < length2 - 1 && welshMap.containsKey(word2.substring(j, j + 2))) { // same applies to second word
					firstCharacterWord2 = word2.substring(j, j + 2);
					j++;
				}
				
				i++;
				j++;
				
				if (welshMap.get(firstCharacterWord1) == welshMap.get(firstCharacterWord2))
					continue;

				if (welshMap.get(firstCharacterWord1) > welshMap.get(firstCharacterWord2))
					return 1;

				if (welshMap.get(firstCharacterWord1) < welshMap.get(firstCharacterWord2))
					return -1;
			}

			return (word1.length() > word2.length()) ? 1 : -1;
		});

		return words;

	}

}
