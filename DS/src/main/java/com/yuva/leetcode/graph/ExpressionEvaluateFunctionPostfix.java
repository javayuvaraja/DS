package com.yuva.leetcode.graph;

/**
 * 1628. Design an Expression Tree With Evaluate Function
 
 Given the postfix tokens of an arithmetic expression, build and return the binary expression tree that represents this expression.

Postfix notation is a notation for writing arithmetic expressions in which the operands (numbers) appear before their operators. 
For example, the postfix tokens of the expression 4*(5-(7+2)) are represented in the array postfix = ["4","5","7","2","+","-","*"].

The class Node is an interface you should use to implement the binary expression tree. 
The returned tree will be tested using the evaluate function, which is supposed to evaluate the tree's value. 
You should not remove the Node class; however, you can modify it as you wish, and you can define other classes to implement it if needed.

A binary expression tree is a kind of binary tree used to represent arithmetic expressions. 
Each node of a binary expression tree has either zero or two children. 
Leaf nodes (nodes with 0 children) correspond to operands (numbers), and internal nodes (nodes with two children) 
correspond to the operators '+' (addition), '-' (subtraction), '*' (multiplication), and '/' (division).

It's guaranteed that no subtree will yield a value that exceeds 109 in absolute value, 
and all the operations are valid (i.e., no division by zero).

Follow up: Could you design the expression tree such that it is more modular? 
For example, is your design able to support additional operators without making changes to your existing evaluate implementation?

 

Example 1:


Input: s = ["3","4","+","2","*","7","/"]
Output: 2
Explanation: this expression evaluates to the above binary tree with expression ((3+4)*2)/7) = 14/7 = 2.
Example 2:


Input: s = ["4","5","2","7","+","-","*"]
Output: -16
Explanation: this expression evaluates to the above binary tree with expression 4*(5-(2+7)) = 4*(-4) = -16.
 

Constraints:

1 <= s.length < 100
s.length is odd.
s consists of numbers and the characters '+', '-', '*', and '/'.
If s[i] is a number, its integer representation is no more than 105.
It is guaranteed that s is a valid expression.
The absolute value of the result and intermediate values will not exceed 109.
It is guaranteed that no expression will include division by zero.
 */
import java.util.Stack;

public class ExpressionEvaluateFunctionPostfix {

	abstract class Node {
		public abstract int evaluate();
	};

	class NumNode extends Node {
		int val;

		public NumNode(int val) {
			this.val = val;
		}

		public int evaluate() {
			return val;
		}
	}

	abstract class OpNode extends Node {
		Node left;
		Node right;

		public OpNode(Node left, Node right) {
			this.left = left;
			this.right = right;
		}
	}

	class AddOpNode extends OpNode {
		public AddOpNode(Node left, Node right) {
			super(left, right);
		}

		public int evaluate() {
			return this.left.evaluate() + this.right.evaluate();
		}
	}

	class SubOpNode extends OpNode {
		public SubOpNode(Node left, Node right) {
			super(left, right);
		}

		public int evaluate() {
			return this.left.evaluate() - this.right.evaluate();
		}
	}

	class MultiplyOpNode extends OpNode {
		public MultiplyOpNode(Node left, Node right) {
			super(left, right);
		}

		public int evaluate() {
			return this.left.evaluate() * this.right.evaluate();
		}
	}

	class DivideOpNode extends OpNode {
		public DivideOpNode(Node left, Node right) {
			super(left, right);
		}

		public int evaluate() {
			return this.left.evaluate() / this.right.evaluate();
		}
	}

	/**
	 * This is the TreeBuilder class. You can treat it as the driver code that takes
	 * the postinfix input and returns the expression tree represnting it as a Node.
	 */

	Node buildTree(String[] postfix) {
		Stack<Node> st = new Stack<>();
		for (String token : postfix) {
			if (Character.isDigit(token.charAt(0))) {
				st.push(new NumNode(Integer.parseInt(token)));
			} else {
				Node right = st.pop();
				Node left = st.pop();
				st.push(buildNode(token, left, right));
			}
		}
		return st.peek();
	}

	private Node buildNode(String op, Node left, Node right) {
		switch (op) {
		case "+":
			return new AddOpNode(left, right);
		case "-":
			return new SubOpNode(left, right);
		case "*":
			return new MultiplyOpNode(left, right);
		case "/":
			return new DivideOpNode(left, right);
		default:
			return null;
		}
	}

}
