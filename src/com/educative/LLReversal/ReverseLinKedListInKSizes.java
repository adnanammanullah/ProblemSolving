package com.educative.LLReversal;
/**
 * Given the head of a LinkedList and a number ‘k’, reverse every ‘k’ sized sub-list starting from the head.
 * If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.
 */
public class ReverseLinKedListInKSizes {
	
	
	public static ListNode reverseLL(ListNode head, int k) {
		/**
		 * this function gets the sub array reversed along with left array end, rev array end,
		 * rev array start, and start of remaining right array
		 * then use these pointer to connect the array and recalls the reverseLL with udpated
		 * parameters
		 */
		ListNode [] retNodes;
		ListNode prev=null;
		ListNode nextHead=null;
		do {
			retNodes = reverseLL(prev, null!=nextHead?nextHead:head, k);
			
			ListNode revEnd = retNodes[0];
			ListNode revStart = retNodes[1];
			ListNode prevStart = retNodes[2];
			nextHead = retNodes[3];
			
			revEnd.next = nextHead;
			if(prevStart!=null)
				prevStart.next = revStart;
			else
				head=revStart;
			
			prev=revEnd;
			
		} while(nextHead!=null);
		
		return head;
	}
	
	public static ListNode[] reverseLL(ListNode prev, ListNode head, int k) {
		/**
		 * this function only reverse the chunk that is assigned to it
		 * and return the updated headers (headCopy as End of this chunk, prev and start of this
		 * reversed chunk) of that particular chunk 
		 * along with last element of left array(prevCopy) and first element of right array(head)
		 */
		ListNode next;
		ListNode headCopy = head;
		ListNode prevCopy=prev;
		while(head!=null && k>0) {
			next = head.next;
			head.next=prev;
			prev=head;
			head=next;
			k--;
		}
		return new ListNode[] {headCopy, prev, prevCopy, head};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
	    head.next = new ListNode(2);
	    head.next.next = new ListNode(3);
	    head.next.next.next = new ListNode(4);
	    head.next.next.next.next = new ListNode(5);
	    head.next.next.next.next.next = new ListNode(6);
	    head.next.next.next.next.next.next = new ListNode(7);
	    
	    ListNode result = reverseLL(head, 3);
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

	    result = reverseLL(head, 3);
	    System.out.print("Nodes of the reversed LinkedList are: ");
	    while (result != null) {
	      System.out.print(result.value + " ");
	      result = result.next;
	    }
	}

}
