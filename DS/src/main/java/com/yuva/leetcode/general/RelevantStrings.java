package com.yuva.leetcode.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;

/**
 
 Karat
 Give a list of string list, the inner list represents the related strings, and the question was to find the relevant string for each string. The most relevant string refers to the most common occurrences of other strings and this string.

Input:
[['Casper', 'Purple', 'Wayfair'],['Purple', 'Wayfair', 'Tradesy'],['Wayfair', 'Tradesy', 'Peloton']]

Output:
{
   'Casper': ['Purple', 'Wayfair'],
   'Purple': ['Wayfair'],
   'Wayfair': ['Purple', 'Tradesy'],
   'Tradesy': ['Wayfair'],
   'Peloton': ['Wayfair', 'Tradesy']
   
   
[['Casper', 'Purple', 'Wayfair'],['Purple', 'Wayfair', 'Tradesy'],['Wayfair', 'Tradesy', 'Peloton']]
['Casper', 'Purple', 'Wayfair'] have some similarity, maybe their price?
['Purple', 'Wayfair', 'Tradesy'], are similar, maybe their colours?
etc.
Your goal is to - given the list of similarities, return for each "product", the most similar products.
You can get a single similar product, or several if all the others ones are "equal".

Here's an example where you go about looking for the most similar products to Casper - we iterate through all the sublists:
['Casper', 'Purple', 'Wayfair']
Tentative answer: Casper: [Purple(1), Wayfair(1)] The 1's are there to indicate that these are similar in one way (price, colour, etc)
['Purple', 'Wayfair', 'Tradesy']
No update to Casper, ignore for this example
['Wayfair', 'Tradesy', 'Peloton']
No update to Casper, ignore for this example,

So because Casper is most related to Purple Wayfair (it's only related with them in 1-dimension (maybe price)) - that's the answer
Casper: ['Purple', 'Wayfair']

For Purple it would look like this:
Tentative answer: ['Casper', 'Purple', 'Wayfair']
Purple: [Casper(1), Wayfair(1)]
['Purple', 'Wayfair', 'Tradesy']
Modify your answer to take into account that it's even more connected to Wayfair and that it's also connected to Tradesy: Purple: [casper(1),Wayfair(2),Tradesy(1)]
['Wayfair', 'Tradesy', 'Peloton']
No purple here so ignore this sublist (no need to update Purple)

Answer is Purple: [Wayfair] because Wayfair is similar to Purple in two ways rather than just 1 way (like Tradesy and Peloton are), it's thus the most similar.
 * @author Yuvaraja Kanagarajan
 *
 */
public class RelevantStrings {

	private static Map<String, List<String>> findRelevant(List<List<String>> relevants){
		Map<String, List<String>> resultMap = new HashMap<>();
		Map<String, Map<String, Integer>> countMap = new HashMap<>();
		
		for (List<String> currList : relevants) {
			for (int i =0; i < currList.size(); i++) {
				String curr = currList.get(i);
				Map<String, Integer> temp = countMap.getOrDefault(curr, 
						new HashMap<String, Integer>());
				countMap.put(curr, temp);
				for (int j =0; j < currList.size(); j++ ) {
					if (i==j) {
						continue;
					}
					String related = currList.get(j);
					temp.put(related, temp.getOrDefault(related, 0)+1);
				}
			}
		}
		
		for (String keyWord : countMap.keySet()) {
			Map<String, Integer> temp = countMap.get(keyWord);
			OptionalInt max = temp.keySet().stream().mapToInt(e->temp.get(e)).max();
			List<String> resList =  new ArrayList<>();
			resultMap.put(keyWord, resList);
			for (String word : temp.keySet()) {
				if (temp.get(word) == max.getAsInt()) {
					//result
					resList.add(word);
				}
			}
		}
		
		return resultMap;
	}
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Casper"); list.add("Purple");  list.add("Wayfair");
		
		List<String> list1 = new ArrayList<>();
		list1.add("Purple"); list1.add("Wayfair"); list1.add("Tradesy");
		
		List<String> list2 = new ArrayList<>();
		list2.add("Wayfair"); list2.add("Tradesy"); list2.add("Peloton");
		
		List<List<String>> relevantList = new ArrayList<List<String>>();
		relevantList.add(list);
		relevantList.add(list1);
		relevantList.add(list2);;
		
		findRelevant(relevantList);
	}
	
	
	
}
