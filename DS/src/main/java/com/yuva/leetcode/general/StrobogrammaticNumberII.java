package com.yuva.leetcode.general;

import java.util.ArrayList;
import java.util.List;

/**
 * 247. Strobogrammatic Number II A strobogrammatic number is a number that
 * looks the same when rotated 180 degrees (looked at upside down).
 * 
 * Find all strobogrammatic numbers that are of length = n.
 * 
 * For example, Given n = 2, return ["11","69","88","96"].
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class StrobogrammaticNumberII {

	int target;

	public List<String> findStrobogrammatic(int n) {
		target = n;
		return find(n);
	}

	public List<String> find(int n) {
		List<String> res = new ArrayList<>();
		if (n == 0) {
			res.add("");
			return res;
		}
		if (n == 1) {
			res.add("1");
			res.add("0");
			res.add("8");
			return res;
		}

		List<String> prev = find(n - 2);

		for (String s : prev) {
			if (n != target) {
				res.add("0" + s + "0");
			}
			res.add("1" + s + "1");
			res.add("8" + s + "8");
			res.add("6" + s + "9");
			res.add("9" + s + "6");
		}

		return res;
	}
	
	public static void main(String[] args) {
		StrobogrammaticNumberII obj = new StrobogrammaticNumberII();
		obj.find(3).stream().forEach(System.out::println);
	}
}
