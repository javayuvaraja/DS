package com.yuva.java;

import java.util.Comparator;

public class PersonAgeComparator implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		return o1.age - o2.age;
	}

}
