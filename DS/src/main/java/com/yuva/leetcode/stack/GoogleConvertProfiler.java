package com.yuva.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**

Convert profiler log output to an outline. Let's say we have a simple profiler that logs a line to a file with the time when each method is entered or exited. For example, if main() calls foo() then the output is:

t1, main, enter
t2, foo1, enter
t3, foo1, exit
t4, foo2, enter
t5, foo2, exit
t6, main, exit
For above logs, output should be printed as. Note there is a tab after main.

main (t6 - t1)
  foo1 (t3 - t2)
  foo2 (t5 - t4)
Follow up:
What if same function is getting called over and again as in recursion?

t1, main, enter
t2, foo, enter
t3, foo, enter
t4, foo, exit
t5, foo, exit
t6, main, exit
For above logs, output should be printed as. Note there is a tab after main.

main (t6 - t1)
  foo (t4 - t3)
	  foo (t5 - t2)
	  
	  
 * @author Yuvaraja Kanagarajan
 *
 */
public class GoogleConvertProfiler {

	public static void solution(String[] data) {
		int len = data.length;
		String[][] input = new String[len][3];

		for (int i = 0; i < data.length; i++) {
			input[i] = data[i].split(",");
		}
		Stack<Node> stack = new Stack<>();
		Node root = new Node();
		stack.push(root);

		for (String[] d : input) {
			String time = d[0].trim(), name = d[1].trim(), command = d[2].trim();

			if (command.equalsIgnoreCase("enter")) {
				Node child = new Node(name, time);
				if (!stack.isEmpty()) {
					Node parent = stack.peek();
					parent.add(child);
				}
				stack.push(child);

			} else {
				Node cur = stack.pop();
				cur.end = time;
			}

		}

		print(root, 0);

	}

	public static void print(Node root, int level) {

		if (root.name != null) {
			for (int i = 0; i < level - 1; i++) {
				System.out.print("\t");
			}
			System.out.printf("%s ( %s - %s ) \n", root.name, root.end, root.start);
		}

		for (Node child : root.children) {
			print(child, level + 1);
		}

	}

	private static class Node {

		String name;
		String start, end;
		List<Node> children;

		Node() {
			children = new ArrayList<>();
		}

		Node(String name, String start) {
			this();
			this.name = name;
			this.start = start;

		}

		public void add(Node child) {
			children.add(child);
		}
	}
}
