package com.yuva.java8;

import java.util.List;

public class IterableForEach {

	public static void iteratePerson(List<Person> personList) {
		personList.forEach(p->System.out.println(p));
	}
}
