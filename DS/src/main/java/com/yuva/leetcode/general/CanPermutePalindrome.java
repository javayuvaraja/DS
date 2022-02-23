package com.yuva.leetcode.general;

import java.util.HashSet;
import java.util.Set;

public class CanPermutePalindrome {

	public boolean canPermutePalindrome(String s) {
		Set<Character> set = new HashSet<>();
		for (char c : s.toCharArray()) {
			if (set.contains(c)) {
				set.remove(c);
			} else {
				set.add(c);
			}
		}
		return set.size() == 0 || set.size() == 1;
	}
}
