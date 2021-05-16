package com.yuva.leetcode.stack;

import java.util.Stack;

public class BrowserHistoryI {
	Stack<String> history;
	Stack<String> future;

	public BrowserHistoryI(String homepage) {
		history.push(homepage);
		future = new Stack<String>(); // Reset the forward stack.
	}

	public void visit(String url) {
		history.push(url);
		future.clear();
	}

	public String back(int steps) {
		while (steps > 0 && history.size() > 1) { // Always keep at least one element in the stack.
			future.push(history.pop());
			steps--;
		}
		return history.pop();
	}

	public String forward(int steps) {
		while (steps > 0 && future.size() > 0) {
			history.push(future.pop());
			steps--;
		}
		return history.pop();
	}
}
