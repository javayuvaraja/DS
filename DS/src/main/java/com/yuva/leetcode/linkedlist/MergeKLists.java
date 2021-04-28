package com.yuva.leetcode.linkedlist;

public class MergeKLists {

	public static ListNode mergeKLists(ListNode[] lists){
        return partion(lists,0,lists.length-1);
    }
    public static ListNode partion(ListNode[] lists,int start,int end){
        if(start==end)  return lists[start];
        if(start<end){
            int mid=(start+end)/2;
            ListNode l1=partion(lists,start,mid);
            ListNode l2=partion(lists,mid+1,end);
            return merge(l1,l2);
        }else
            return null;
    }

    //This function is from Merge Two Sorted Lists.
    public static ListNode merge(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next=merge(l1.next,l2);
            return l1;
        }else{
            l2.next=merge(l1,l2.next);
            return l2;
        }
    }
    
	public static ListNode mergeIterative(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode curr = head;

		ListNode p1 = l1;
		ListNode p2 = l2;
		while (p1 != null && p2 != null) {
			if (p1.val < p2.val) {
				curr.next = p1;
				p1 = p1.next;
			} else {
				curr.next = p2;
				p2 = p2.next;
			}
			curr = curr.next;
		}

		if (p1 != null) {
			curr.next = p1;
		}

		if (p2 != null) {
			curr.next = p2;
		}

		return head.next;
	}
    
}
