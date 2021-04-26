package com.yuva.leetcode.string;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
Leetcode : 358. Rearrange String k Distance Apart
Given a non-empty string str and an integer k, rearrange the string such that the same characters are at least distance k from each other.

All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".

Example 1: str = "aabbcc", k = 3

Result: "abcabc"

The same letters are at least distance 3 from each other. Example 2: str = "aaabc", k = 3

Answer: ""

It is not possible to rearrange the string. Example 3: str = "aaadbbcc", k = 2

Answer: "abacabcd"

Another possible answer is: "abcabcda"

 * @author Yuvaraja Kanagarajan
 *
 */
		
public class RearrangeStringKDistanceApart {

	public String rearrangeString(String str, int k) {

        if(k == 0) return str;
        int len = str.length();

        // Frquency map
        Map<Character, Integer> freqMap = new HashMap<>();
        for(int i=0; i< len; i++){
            char ch = str.charAt(i);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(10, new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                if(p1.cnt != p2.cnt) return p2.cnt - p1.cnt;
                else return  p2.ch - p1.ch; // to ensure the order of the chars with same count, they should show up in same order.
            }
        });

        for(Map.Entry<Character, Integer> entry : freqMap.entrySet()){
            pq.offer(new Pair(entry.getKey(), entry.getValue()));// pick the most show-up char first.
        }

        StringBuilder sb = new StringBuilder();
        
        while(!pq.isEmpty()){
            List<Pair> tmp = new ArrayList<>();// this is avoid you pick up same char in the same k-segment.
            int d = Math.min(k, len);
            for(int i=0; i< d; i++){
                if(pq.isEmpty()) return "";
                Pair pair = pq.poll();
                sb.append(pair.ch);
                pair.cnt--;
                if(pair.cnt > 0) {
                	tmp.add(pair);
                }
                len--;
            }
            
            for(Pair p : tmp) {
            	pq.offer(p);
            }

        }

        return sb.toString();

    }

    class Pair{
        char ch;
        int cnt;
        Pair(char c, int t){
            ch = c;
            cnt = t;
        }
    };
}
