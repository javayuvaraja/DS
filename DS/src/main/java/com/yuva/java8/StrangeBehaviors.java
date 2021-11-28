package com.yuva.java8;

import java.util.Set;
import java.util.TreeSet;

public class StrangeBehaviors {

	public static void main(String[] args) {
		hashSetNull();
	}

	public static void intComparision() {
		// Integer comparison
		Integer a = 1000, b = 1000;
		System.out.println(a == b);

		Integer c = 100, d = 100;
		System.out.println(c == d);
	}

	public static void hashSetNull() {
		Set<String> set = new TreeSet<>();
		set.add(null);
		set.add("yuva");
		System.out.println("Null test completed");
	}
}


/*

1. int a = 1L; won’t compile and int b = 0; b += 1L; compiles fine. Why ?
	When += is used, that’s a compound statement and the compiler internally casts it. Whereas in the first case, 
	the compiler straight away shouts at you since it is a direct statement.

2. ListIterator - Only can used to list, cannot be used to sets. 
                - Iterator traverses only on forward, ListIterator traverses both the direction 
 
 */
