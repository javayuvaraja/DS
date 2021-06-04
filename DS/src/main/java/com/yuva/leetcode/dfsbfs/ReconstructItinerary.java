package com.yuva.leetcode.dfsbfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
332. Reconstruct Itinerary

You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and 
the arrival airports of one flight. Reconstruct the itinerary in order and return it.

All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". 
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.

For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.

 
 * @author Yuvaraja Kanagarajan
 *
 */
public class ReconstructItinerary {

	Map<String, PriorityQueue<String>> iteineraryMap = new HashMap<>();

	public List<String> findItinerary(List<List<String>> tickets) {
		for (List<String> ticket : tickets) {
			String source = ticket.get(0);
			String dest = ticket.get(1);
			iteineraryMap.computeIfAbsent(source, k -> new PriorityQueue<String>()).add(dest);
		}
		List<String> routeList = new LinkedList<>();
		dfs("JFK", routeList);
		return routeList;
	}

	void dfs(String departure, List<String> routeList) {

		PriorityQueue<String> arrivals = iteineraryMap.get(departure);
		while (arrivals != null && !arrivals.isEmpty()) {
			dfs(arrivals.poll(), routeList);
		}
		routeList.add(0, departure); // adding at the first
	}
	
	public List<String> findItineraryIterative (String[][] tickets) {
	    Map<String, PriorityQueue<String>> targets = new HashMap<>();
	    for (String[] ticket : tickets)
	        targets.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
	    List<String> route = new LinkedList<>();
	    Stack<String> stack = new Stack<>();
	    stack.push("JFK");
	    while (!stack.empty()) {
	        while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty())
	            stack.push(targets.get(stack.peek()).poll());
	        route.add(0, stack.pop());
	    }
	    return route;
	}

}
