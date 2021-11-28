package com.yuva.leetcode.general;

public class RLEIterator {

	int[] A;
	int countIndex = 0;

	public RLEIterator(int[] A) {
		this.A = A;
	}

	public int next(int n) {
		int num = 0;
		boolean isFound = false;
		while (n > 0 && !isFound ) {
			if (countIndex >= A.length) // out of array
				return -1;
			
			if (A[countIndex] == 0) {
				countIndex += 2;
				continue;
			}
			
			int remaining = A[countIndex] - n;
			
			if (remaining >= 0) {
				num = A[countIndex + 1];
				A[countIndex] = remaining;
				isFound = true;
			} else {
				n = n - A[countIndex];
				countIndex += 2;
			}
		}
		return num;
	}
	
	public static void main(String[] args) {
		//int arr[]= {3, 8, 0, 9, 2, 5};
		int arr[]= {784,303,477,583,909,505};
		
		RLEIterator obj = new RLEIterator(arr);
		
		//System.out.println(obj.next(2));
		//System.out.println(obj.next(1));
		//System.out.println(obj.next(1));
		//System.out.println(obj.next(2));
		
		
		System.out.println(obj.next(130));
		System.out.println(obj.next(333));
		System.out.println(obj.next(238));
		System.out.println(obj.next(87));
		System.out.println(obj.next(301));
		System.out.println(obj.next(276));
		
	}
	
	
	
	/**
	 * 
	 * Binary Search Solution
	 * class RLEIterator {

	long[] count;
	int[] num;

	long cur = 0;    
	int low = 0;
	public RLEIterator(int[] A) {
		count = new long[A.length/2];
		num = new int[A.length/2];
		for (int i=0; i<A.length; i+=2) {
			count[i/2] = A[i] + (i>1? count[i/2 - 1] : 0);
			num[i/2] = A[i+1];
		}
	}

	public int next(int n) {
		if (count.length==0) return -1;
		cur += n;
		if (cur > count[count.length-1]) return -1;
		int l=low, h=count.length-1;

		while(l < h) {
			int mid = l + (h-l)/2;
			if (count[mid] >= cur) {
				h = mid;
			} else {
				l = mid+1;
			}
		}
		low = l;
		return num[l];
	}
}
	 */
}