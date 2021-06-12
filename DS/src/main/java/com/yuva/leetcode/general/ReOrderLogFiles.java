package com.yuva.leetcode.general;

import java.util.Arrays;
import java.util.Comparator;

/**
937. Reorder Data in Log Files
Easy

1132

2983

Add to List

Share
You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.

There are two types of logs:

Letter-logs: All words (except the identifier) consist of lowercase English letters.
Digit-logs: All words (except the identifier) consist of digits.
Reorder these logs so that:

The letter-logs come before all digit-logs.
The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
The digit-logs maintain their relative ordering.
Return the final order of the logs.
 * @author Yuvaraja Kanagarajan
 *
 */
public class ReOrderLogFiles {
	public static String[] reorderLogFiles(String[] logs) {
		Comparator<String> myComp = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				int s1si = s1.indexOf(' ');
				int s2si = s2.indexOf(' ');
				char s1fc = s1.charAt(s1si + 1);
				char s2fc = s2.charAt(s2si + 1);

				// If both the strings are digits then return first,
				// if first is digit and the second one is letter then second one.
				if (Character.isDigit(s1fc)) {
					if (Character.isDigit(s2fc))
						return 0;
					else
						return 1;
				}
				// if first one is letter and second one is digit return the first.
				if (Character.isDigit(s2fc))
					return -1;

				// if both are letters then compare the content
				int preCompute = s1.substring(s1si + 1).compareTo(s2.substring(s2si + 1));
				if (preCompute == 0)
					return s1.substring(0, s1si).compareTo(s2.substring(0, s2si));
				return preCompute;
			}
		};

		Arrays.sort(logs, myComp);
		return logs;
	}
}
