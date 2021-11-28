package com.yuva.leetcode.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindAndReplaceString {

	public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder result = new StringBuilder();
        int prevIndex = 0;
        List<int[]> sortedIndexes = new ArrayList<>();
        for (int i = 0; i < indexes.length; i++)
            sortedIndexes.add(new int[]{indexes[i], i});
        Collections.sort(sortedIndexes, (a, b) -> a[0] - b[0]);

        for (int sortedIndex[] : sortedIndexes) {
            int i = sortedIndex[0];
            int j = sortedIndex[1];
            String src = sources[j];
            String target = targets[j];
            result.append(S.substring(prevIndex, i)); //append previous string before i
            prevIndex = i; //update prevIndex to i as we already appended before i
            if (S.substring(i, i + src.length()).equals(src)) { 
                result.append(target);
                prevIndex += src.length();//skip prevIndex by src.length as we appended target
            }
        }
        result.append(S.substring(prevIndex, S.length())); // add remaining S from prevIndex 
        return result.toString();
    }
	
	/**
	 * Right to left logic
	 * 1. Sort based on the index
	 * @param args
	 */
	
	public String findReplaceString1(String S, int[] indexes, String[] sources, String[] targets) {
        List<int[]> sorted = new ArrayList<>();
        for (int i = 0 ; i < indexes.length; i++) sorted.add(new int[]{indexes[i], i});
        Collections.sort(sorted, Comparator.comparing(i -> -i[0]));
        for (int[] ind: sorted) {
            int i = ind[0], j = ind[1];
            String source = sources[j], target = targets[j];
            if (S.substring(i, i + source.length()).equals(source)) {
            	S = S.substring(0, i) + target + S.substring(i + source.length());
            }
        }
        return S;
    }
	
	public static void main(String[] args) {
		String s = "abcd";
		int indices[] = {0, 2};
		String []sources = {"a","cd"};
		String []targets = {"eee","ffff"};
		FindAndReplaceString obj = new FindAndReplaceString();
		String result = obj.findReplaceString(s, indices, sources, targets);
		System.out.println(result);
		
	}

}
