package com.yuva.java;

import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		
		TreeSet<Person> obj = new TreeSet<>(new PersonAgeComparator());
		obj.add(new Person(10, "krish"));
		obj.add(new Person(20, "yuvaraja"));
		obj.add(new Person(15, "udhaya"));
		obj.add(new Person(40, "amirtha"));
		
		System.out.println(obj);
		
		TreeSet<Integer> obj1 = new TreeSet<>();
		obj1.add(10);
		obj1.add(90);
		obj1.add(30);
		obj1.add(40);
		obj1.add(50);
		System.out.println(obj1);
		
	}
}
