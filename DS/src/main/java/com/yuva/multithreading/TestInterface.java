package com.yuva.multithreading;

public class TestInterface implements i1, i2{

	@Override
	public void m1() {
		i1.super.m1();
	}
	
	public static void main(String[] args) {
		String str = new String ("udhaya");
		String str1 = "udhaya";
		String str2 = str.intern();
		System.out.println(str==str1);
		System.out.println(str==str2);
		System.out.println(str1==str2);
		
			
	}

	
}


interface i1{
	public default void m1() {
		System.out.println("I1");
	}
}

interface i2{
	public default void m1() {
		System.out.println("I2");
	}
}
