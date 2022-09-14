/**
 * Given the head of a Singly LinkedList, reverse the LinkedList. 
 * Write a function to return the new head of the reversed LinkedList.
 */

package com.educative.LLReversal;

public class ReverseSingleLL {
	
	public static ListNode reverse(ListNode head) {
		ListNode temp=null, prev=null;
		while(head!=null) {
			temp=head.next;
			head.next=prev;
			prev=head;
			head=temp;
		}
		
		return prev;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(2);
	    head.next = new ListNode(4);
	    head.next.next = new ListNode(6);
	    head.next.next.next = new ListNode(8);
	    head.next.next.next.next = new ListNode(10);

	    ListNode result = ReverseSingleLL.reverse(head);
	    System.out.print("Nodes of the reversed LinkedList are: ");
	    while (result != null) {
	      System.out.print(result.value + " ");
	      result = result.next;
	    }
	}

}
