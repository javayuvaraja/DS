package com.yuva.java8;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FunctionTest {

	/*
		
		@FunctionalInterface
		public interface Predicate<T> {
			public boolean test(T t); // Evaluates this predicate on the given object.
		}
		
		@FunctionalInterface
		public interface Consumer<T> {
			public void accept(T t); // Run this operation on the given object.
		}
		
		@FunctionalInterface
		public Function<T, R> {
			public R apply(T t); // Apply this mapping to the given object.
		}
		
		@FunctionalInterface
		public Supplier<T> {
			public T get(); // Gets a result.
		}
		*/
	
	
	public static void FilterReduce1(List<Person> pList, Predicate<Person> predicate, 
						Consumer<Person> consumer) {
		for (Person p : pList) {
			if (predicate.test(p)) {
				consumer.accept(p);
			}
		}
	}
	
	public Supplier<Person> getPersonSupplier(){
        Supplier<Person>  personSupplier = () -> new Person();
        return personSupplier;
	}
	
	public static void printRandomNumber() {
		Supplier<Integer> randomNumbersSupp=() -> new Random().nextInt(10);
        Stream.generate(randomNumbersSupp)
                        .limit(5)
                        .forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		int capacity = 40;
        int newCapacity = capacity + (capacity >> 1);
        System.out.println(newCapacity);

	}
}
