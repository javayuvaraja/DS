package com.yuva.leetcode.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class SearchSuggestion {

	class Trie {
        Trie[] sub = new Trie[26];
        LinkedList<String> suggestion = new LinkedList<>();
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = new Trie();
        for (String p : products) { // build Trie.
            insert(p, root); // insert a product into Trie.
        }
        return search(searchWord, root);
    }
    private void insert(String p, Trie root) {
        Trie t = root;
        for (char c : p.toCharArray()) { // insert current product into Trie.
            if (t.sub[c - 'a'] == null)
                t.sub[c - 'a'] = new Trie();
            t = t.sub[c - 'a'];
            t.suggestion.offer(p); // put products with same prefix into suggestion list.
            Collections.sort(t.suggestion);
            if (t.suggestion.size() > 3) // maintain 3 lexicographically minimum strings.
                t.suggestion.pollLast();        
        }
    }
    private List<List<String>> search(String searchWord, Trie root) {
        List<List<String>> ans = new ArrayList<>();
        for (char c : searchWord.toCharArray()) { // search product.
            if (root != null) // if there exist products with current prefix.
                root = root.sub[c - 'a'];
            ans.add(root == null ? Arrays.asList() : root.suggestion); // add it if there exist products with current prefix.
        }
        return ans;
    }
    
    public List<List<String>> suggestedProducts1(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        Arrays.sort(products); // sort products.
        for (int i = 1; i <= searchWord.length(); ++i) {
            String cur = searchWord.substring(0, i);
            int k = Arrays.binarySearch(products, cur);
            while (k > 0 && cur.equals(products[k - 1])) // in case there are more than 1 cur in products.
                --k; // find the first one. 
            if (k < 0) // no cur in products. 
                k = ~k; // find the first one larger than cur.
            List<String> suggestion = new ArrayList<>();
            for (int j = k + 3; k < products.length && k < j && products[k].startsWith(cur); ++k)
                suggestion.add(products[k]);
            ans.add(suggestion);
        }
        return ans;
    }
    
    public List<List<String>> suggestedProducts2(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        TreeMap<String, Integer> map = new TreeMap<>();
        Arrays.sort(products);
        List<String> productsList = Arrays.asList(products);

        for (int i = 0; i < products.length; i++) {
            map.put(products[i], i);
        }

        String key = "";
        for (char c : searchWord.toCharArray()) {
            key += c;
            String ceiling = map.ceilingKey(key);
            String floor = map.floorKey(key + "~");
            if (ceiling == null || floor == null) break;
            res.add(productsList.subList(map.get(ceiling), Math.min(map.get(ceiling) + 3, map.get(floor) + 1)));
        }

        while (res.size() < searchWord.length()) res.add(new ArrayList<>());
        return res;
    }
    
    public static void main(String[] args) {
    	String []products = new String[] {"mobile","mouse","moneypot","monitor","moz", "mousepad"};
    	String searchWord = "moze";
    	SearchSuggestion obj = new SearchSuggestion();
    	List<List<String>> result = obj.suggestedProducts1(products, searchWord);
    	System.out.println(result);
	}
}
