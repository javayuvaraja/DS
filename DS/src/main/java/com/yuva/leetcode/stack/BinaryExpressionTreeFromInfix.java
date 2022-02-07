package com.yuva.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
1597. Build Binary Expression Tree From Infix Expression

A binary expression tree is a kind of binary tree used to represent arithmetic expressions. 
Each node of a binary expression tree has either zero or two children. Leaf nodes (nodes with 0 children) 
correspond to operands (numbers), and internal nodes (nodes with 2 children) correspond to the 
operators '+' (addition), '-' (subtraction), '*' (multiplication), and '/' (division).

For each internal node with operator o, the infix expression that it represents is (A o B), 
where A is the expression the left subtree represents and B is the expression the right subtree represents.

You are given a string s, an infix expression containing operands, the operators described above, and parentheses '(' and ')'.

Return any valid binary expression tree, which its in-order traversal reproduces 
s after omitting the parenthesis from it (see examples below).

Please note that order of operations applies in s. That is, expressions in parentheses are evaluated first, 
and multiplication and division happen before addition and subtraction.

Operands must also appear in the same order in both s and the in-order traversal of the tree.

 * @author Yuvaraja Kanagarajan
 *
 */
public class BinaryExpressionTreeFromInfix {

	 int p = 0;
	    public Node expTree(String s) {
	        Deque<Node> operators = new ArrayDeque<>();
	        Deque<Node> operands = new ArrayDeque<>();
	        while(p < s.length()) {
	            char cur = s.charAt(p++);
	            if(cur >= '0' && cur <= '9') {
	                operands.push(new Node(cur));
	            } else if(cur == '-' || cur == '+' || cur == '*' || cur == '/') {
	                while(!operators.isEmpty() && compareOperator(cur, operators.peek().val)) {
	                    Node r = operands.pop(), l = operands.pop();
	                    Node op = operators.pop();
	                    op.left = l;
	                    op.right = r;
	                    operands.push(op);
	                }
	                operators.push(new Node(cur));
	            } else if(cur == '(') {
	                operands.push(expTree(s));
	            } else if(cur == ')') {
	                break;
	            }
	        }
	        
	        // handle rest numbers in stack
	        // because we use loop inside, so directly use pop is fine
	        // the only reason stack has two operator is that first priority low
	        while(!operators.isEmpty()) {
	            Node r = operands.pop(), l = operands.pop();
	            Node op = operators.pop();
	            op.left = l;
	            op.right = r;
	            operands.push(op);
	        }
	        
	        return operands.pop();
	    }
	    
	    // check l's priority is less or equal than r's priority
	    private boolean compareOperator(char l, char r) {
	        if(l == '*' || l == '/') {
	            if(r == '*' || r == '/') return true; // true means can pop
	            return false;
	        }
	        
	        return true; // if l is + or -, all operator should pop
	    }
	    
	    class Node {
	    	Node left;
	    	Node right;
	    	char val;
	    	Node (char ch) {
	    		this.val = ch;
	    	}
	    	public String toString() {
	    		return ""+val;
	    	}
	    }
	    
	    public static void main(String[] args) {
			String str = "2-3/(5*2)+1";
			BinaryExpressionTreeFromInfix obj = new BinaryExpressionTreeFromInfix();
			Node result = obj.expTree(str);
			obj.inorder(result);
		}
	    
	    public void inorder (Node root ) {
	    	if (root == null) {
	    		return;
	    	}
	    	inorder (root.left);
	    	System.out.println(root.val);	
	    	inorder (root.right);
	    }
}
