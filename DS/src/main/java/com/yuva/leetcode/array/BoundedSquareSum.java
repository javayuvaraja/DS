package com.yuva.leetcode.array;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Uber question
 * 
 * You are given two arrays of integers a and b, and two integers lower and upper.
Your task is to find the number of pairs (i, j) such that lower ≤ a[i] * a[i] + b[j] * b[j] ≤ upper.
Example:
For a = [3, -1, 9], b = [100, 5, -2], lower = 7, and upper = 99, the output should be boundedSquareSum(a, b, lower, upper) = 4.
There are only four pairs that satisfy the requirement:
If i = 0 and j = 1, then a[0] = 3, b[1] = 5, and 7 ≤ 3 * 3 + 5 * 5 = 9 + 25 = 36 ≤ 99.
If i = 0 and j = 2, then a[0] = 3, b[2] = -2, and 7 ≤ 3 * 3 + (-2) * (-2) = 9 + 4 = 13 ≤ 99.
If i = 1 and j = 1, then a[1] = -1, b[1] = 5, and 7 ≤ (-1) * (-1) + 5 * 5 = 1 + 25 = 26 ≤ 99.
If i = 2 and j = 2, then a[2] = 9, b[2] = -2, and 7 ≤ 9 * 9 + (-2) * (-2) = 81 + 4 = 85 ≤ 99.
For a = [1, 2, 3, -1, -2, -3], b = [10], lower = 0, and upper = 100, the output should be boundedSquareSum(a, b, lower, upper) = 0.
Since the array b contains only one element 10 and the array a does not contain 0, it is not possible to satisfy 0 ≤ a[i] * a[i] + 10 * 10 ≤ 100.


 * @author Yuvaraja Kanagarajan
 *
 */
public class BoundedSquareSum {

    int boundedSquareSum(int[] a,int[] b,int lower,int upper){
        if(a.length > b.length){
            return boundedSquareSum(b, a, lower, upper);
        }

        for(int i=0; i < a.length; i++){
            a[i] = a[i] * a[i];
        }

        Arrays.sort(a);

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i < a.length; i++){
            map.put(a[i], i);
        }

        int count =0;
        for(int i=0; i < b.length; i++){
            Map.Entry<Integer, Integer> floorEntry = map.floorEntry(upper - (b[i] * b[i])); // nearest smallest greater number
            Map.Entry<Integer, Integer> ceilEntry = map.ceilingEntry(lower - (b[i] * b[i])); // nearest greatest smaller number
            if(floorEntry != null && ceilEntry != null)
                count += floorEntry.getValue() - ceilEntry.getValue() + 1;  // adding the window smaller to greater
        }
        return count;
    }
}
