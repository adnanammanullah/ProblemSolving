package com.educative.LLReversal;
/**
 * Given the head of a LinkedList and a number ‘k’, reverse every ‘k’ sized sub-list starting from the head.
 * If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.
 */
public class ReverseLinKedListInKSizes {
	
	
	public static ListNode reverseLL(ListNode head, int k) {
		ListNode prevRet=null;
		ListNode prev=null;
		do {
			prevRet = reverseLL(prev, null!=prev?prev.next:head, k);
			if(null==prev)
				head=prevRet;
			
		} while();
		
		return head;
	}
	
	public static ListNode reverseLL(ListNode prev, ListNode head, int k) {
		ListNode next;
		while(k>0 && head!=null) {
			next = head.next;
			head.next=prev;
			prev=head;
			head=next;
			k--;
		}
		return prev;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
