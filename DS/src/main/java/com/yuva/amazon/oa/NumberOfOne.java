package com.yuva.amazon.oa;

public class NumberOfOne {

	public static void main(String[] args) {
		System.out.println(findOneCount(2));
	}
	
	public static int findOneCount(int n) {
		int zero[] = new int[n];
		int one[] = new int[n];
		
		one[0] = 3;
		zero[0] = 2;
		
		if (n==1) {
			return one[n-1];
		}
		one[1] = 4;
		zero[1] = 3;
		
		if (n==2) {
			return one[n-1];
		}
		
		for (int i=2; i < n; i++) {
			 one[i] = one[i-1] + (3 * (zero[i-2]));
			 zero[i] = (2*zero[i-1]) + one[i-2];
		}
		
		return one[n-1];
		
 	}
	
	
}
