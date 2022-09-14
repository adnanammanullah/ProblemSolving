package com.educative.LLReversal;
/**
 * Given the head of a LinkedList and two positions ‘p’ and ‘q’, 
 * reverse the LinkedList from position ‘p’ to ‘q’
 */
public class ReverseSubLL {
	
	 public static ListNode reverse(ListNode head, int p, int q) {
		 
		 if(p==q)
			 return head;
		 
		 int revCounter = q-p+1;
		 ListNode start = head, startPrev=null;
		 p--;
		 while(p>0) {
			 startPrev=start;
			 start=start.next;
			 p--;
		 }
		 ListNode end=start;
		 ListNode endPrev=null;
		 ListNode next;
		 while(revCounter>0 && end!=null) {
			 next = end.next;
			 end.next=endPrev;
			 endPrev=end;
			 end=next;
			 revCounter--;
		 }
		 
		 start.next = end;
		 if(null!=startPrev)
			 startPrev.next=endPrev;
		 else 
			 head=endPrev;
		 
		 
		 return head;
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

	    ListNode result = reverse(head, 3, 3);
	    System.out.print("Nodes of the reversed LinkedList are: ");
	    while (result != null) {
	      System.out.print(result.value + " ");
	      result = result.next;
	    }
	}

}
