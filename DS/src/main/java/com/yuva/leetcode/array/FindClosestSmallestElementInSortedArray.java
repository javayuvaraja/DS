package com.yuva.leetcode.array;

public class FindClosestSmallestElementInSortedArray {

	public static int search(int value, int[] a) {
        if(value < a[0] || value > a[a.length-1]) {
            return -1;
        }
        
        int lo = 0;
        int hi = a.length-1;

        while (lo <= hi) {
            int mid = (hi + lo) / 2;

            if (value < a[mid]) {
                hi = mid - 1;
            } else if (value > a[mid]) {
                lo = mid + 1;
            } else {
                return a[mid];
            }
        }
        // lo == hi + 1
        return (a[lo] - value) < (value - a[hi]) ? lo : hi;
    }
	
	public static void main(String[] args) {
		int arr[] = {1,3,6,7};
		System.out.println(arr[search(8, arr)]);
	}
}
