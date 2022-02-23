package com.yuva.java;

public class Person implements Comparable<Person> {
	String name;
	int age;
	
	public Person(int age, String name) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}
