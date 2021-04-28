package com.yuva.leetcode.general;

public class PowerOf10 {

	public boolean isPowerOf10(int n) {
		if (n==1) {
			return true;
		}
		if (n < 10) {
			return false;
		}
		
		while (n %10 == 0) {
			n= n/10;
		}
		
		return n==1 ? true : false;
	}
	
	
	public static void main(String[] args) {
		PowerOf10 obj = new PowerOf10();
		System.out.println(obj.isPowerOf10(1));
		System.out.println(obj.isPowerOf10(0));
		System.out.println(obj.isPowerOf10(10));
		System.out.println(obj.isPowerOf10(20));
		System.out.println(obj.isPowerOf10(100));
		System.out.println(obj.isPowerOf10(10000));
		
		
	}
	

}
