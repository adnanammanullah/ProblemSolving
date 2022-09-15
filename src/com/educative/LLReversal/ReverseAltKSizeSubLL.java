package com.educative.LLReversal;
/**
 * Given the head of a LinkedList and a number ‘k’, reverse every alternating ‘k’ sized 
 * sub-list starting from the head.
 * If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.
 */
public class ReverseAltKSizeSubLL {
	
	public static ListNode revAlternativeK(ListNode head, int k) {
		ListNode prev = null;
		ListNode newStart = null;
		ListNode [] retNodes;
		do {
			retNodes = reverseLL(prev, null!=newStart?newStart:head, k);
			ListNode leftListEnd = retNodes[0];
			ListNode revListStart = retNodes[1];
			ListNode revListEnd = retNodes[2];
			ListNode rightListStart = retNodes[3];
			
			revListEnd.next = rightListStart;
			if(leftListEnd!=null) {
				leftListEnd.next = revListStart;
			}else
				head = revListStart;
			
			prev = revListEnd;
			newStart = rightListStart;
			
			for(int kk=k; kk>0 && newStart!=null;kk--) {
				prev=newStart;
				newStart=newStart.next;
			}
			
			
		} while(newStart!=null);
		return head;
	}
	
	
	public static ListNode [] reverseLL(ListNode prev, ListNode head, int k) {
		
		ListNode leftListEnd = prev;
		ListNode revListEnd = head;
		
		ListNode next;
		while(head!=null && k>0) {
			next = head.next;
			head.next=prev;
			prev=head;
			head=next;
			k--;
		}
		//now 'head' is rightListStart
		//now prev is revListStart
		
		return new ListNode[] {leftListEnd, prev, revListEnd, head};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				ListNode head = new ListNode(1);
			    head.next = new ListNode(2);
			    head.next.next = new ListNode(3);
			    head.next.next.next = new ListNode(4);
			    head.next.next.next.next = new ListNode(5);
			    head.next.next.next.next.next = new ListNode(6);
			    head.next.next.next.next.next.next = new ListNode(7);
			    
			    ListNode result = revAlternativeK(head, 3);
			    System.out.print("Nodes of the reversed LinkedList are: ");
			    while (result != null) {
			      System.out.print(result.value + " ");
			      result = result.next;
			    }
			    System.out.println();
			    
			    head = new ListNode(1);
			    head.next = new ListNode(2);
			    head.next.next = new ListNode(3);
			    head.next.next.next = new ListNode(4);
			    head.next.next.next.next = new ListNode(5);
			    head.next.next.next.next.next = new ListNode(6);
			    head.next.next.next.next.next.next = new ListNode(7);
			    head.next.next.next.next.next.next.next = new ListNode(8);

			    result = revAlternativeK(head, 3);
			    System.out.print("Nodes of the reversed LinkedList are: ");
			    while (result != null) {
			      System.out.print(result.value + " ");
			      result = result.next;
			    }
			    
			    System.out.println();
			    
			    head = new ListNode(1);
			    head.next = new ListNode(2);
			    head.next.next = new ListNode(3);
			    head.next.next.next = new ListNode(4);
			    head.next.next.next.next = new ListNode(5);
			    head.next.next.next.next.next = new ListNode(6);
			    head.next.next.next.next.next.next = new ListNode(7);
			    head.next.next.next.next.next.next.next = new ListNode(8);

			    result = revAlternativeK(head, 2);
			    System.out.print("Nodes of the reversed LinkedList are: ");
			    while (result != null) {
			      System.out.print(result.value + " ");
			      result = result.next;
			    }
	}

}
