package com.yuva.java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamInterviewQuestion {

	public void findDuplicate() {
		 List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
         Set<Integer> set = new HashSet<>();
         myList.stream()
               .filter(n -> !set.add(n))
               .forEach(System.out::println);
	}
	
	public void findFirstNonRepeatedChar() {
		String input = "Java Hungry Blog Alive is Awesome";

        Character result = input.chars() // Stream of String       
                                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase         
                                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count 
                                .entrySet()
                                .stream()
                                .filter(entry -> entry.getValue() == 1L)
                                .map(entry -> entry.getKey())
                                .findFirst()
                                .get();
        System.out.println(result);     
	}
	
	public void findFirstRepeatedChar() {
		String input = "Java Hungry Blog Alive is Awesome";

        Character result = input.chars() // Stream of String       
                                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase         
                                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count 
                                .entrySet()
                                .stream()
                                .filter(entry -> entry.getValue() > 1L)
                                .map(entry -> entry.getKey())
                                .findFirst()
                                .get();
        System.out.println(result);     
	}
	
	/**
	 * Given a list of people, create a map where their name is the key 
	 * and value is all the ages of people with that name
    
	 * @param people
	 */
	public void groupByWithMapping(List<Person> people) {
		 people.stream()
         .collect(Collectors.groupingBy(Person::getFirstName, 
             Collectors.mapping(Person::getAge, Collectors.toList())));
	}
}
