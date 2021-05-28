package com.yuva.leetcode.linkedlist;

public class AddTwoNumberAsItAs {

	ListNode result;
	int carry;

	void insertToResult(int val) {
		ListNode newnode = new ListNode(val);
		newnode.next = result;
		result = newnode;

	}
	void addsamesize(ListNode node1, ListNode node2) {
		if (node1 == null)
			return;

		addsamesize(node1.next, node2.next);

		// add digits of current nodes and propagated carry
		int sum = node1.val + node2.val + carry;
		carry = sum / 10;
		sum = sum % 10;

		// Push this to result list
		insertToResult(sum);

	}

	ListNode cur;

	void propogatecarry(ListNode head1) {
		if (head1 != cur) {
			propogatecarry(head1.next);
			int sum = carry + head1.val;
			carry = sum / 10;
			sum %= 10;

			// add this node to the front of the result
			insertToResult(sum);
		}
	}

	int getsize(ListNode head) {
		int count = 0;
		while (head != null) {
			count++;
			head = head.next;
		}
		return count;
	}

	void addlists(ListNode head1, ListNode head2) {
		if (head1==null || head2 == null) {
			result = head1==null ? head2 :head1;
			return;
		}

		int size1 = getsize(head1);
		int size2 = getsize(head2);

		// Add same size lists
		if (size1 == size2) {
			addsamesize(head1, head2);
		} else {
			// First list should always be larger than second list.
			// If not, swap pointers
			if (size1 < size2) {
				ListNode temp = head1;
				head1 = head2;
				head2 = temp;
			}
			int diff = Math.abs(size1 - size2);

			// move diff. number of nodes in first list
			ListNode temp = head1;
			while (diff-- >= 0) {
				cur = temp;
				temp = temp.next;
			}

			// get addition of same size lists
			addsamesize(cur, head2);

			// get addition of remaining first list and carry
			propogatecarry(head1);
		}
		// if some carry is still there, add a new node to
		// the front of the result list. e.g. 999 and 87
		if (carry > 0) {
			insertToResult(carry);
		}

	}
	
	public static void main(String[] args) {
		AddTwoNumberAsItAs obj = new AddTwoNumberAsItAs();
		
		ListNode node1= new ListNode(5);
		node1.next = new ListNode(8);
		node1.next.next = new ListNode(9);
		node1.next.next.next = new ListNode(6);
		
		
		ListNode node2= new ListNode(7);
		node2.next = new ListNode(8);
		obj.addlists(node1, node2);
		ListNode result  = obj.result;
		while (result!=null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}

}
