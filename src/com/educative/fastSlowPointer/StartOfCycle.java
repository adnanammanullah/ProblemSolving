package com.educative.fastSlowPointer;


//class ListNode {
//	int value = 0;
//	ListNode next;
//
//	ListNode(int value) {
//		this.value = value;
//	}
//}

class StartOfCycle {

	public static ListNode findCycleStart(ListNode head) {

		ListNode fast = head.next;
		ListNode slow = head;
		int circleLength=0;
		while (fast != null && slow != null && fast != slow) {
			fast = fast.next;
			if (null != fast) {
				fast = fast.next;
			}
			slow = slow.next;
		}
		
		if (null != fast && null != slow && slow == fast) {
			do {
				circleLength+=2;
				fast=fast.next.next;
				slow=slow.next;
			}while(fast!=null && fast.next!=null && fast!=slow);
		}
		
		fast=head;
		slow=head;
		
		while(circleLength>0) {
			fast=fast.next;
			circleLength--;
		}
		
		while(slow!=fast) {
			slow=slow.next;
			fast=fast.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);

		head.next.next.next.next.next.next = head.next.next;
		System.out.println("LinkedList cycle start: " + StartOfCycle.findCycleStart(head).value);

		head.next.next.next.next.next.next = head.next.next.next;
		System.out.println("LinkedList cycle start: " + StartOfCycle.findCycleStart(head).value);

		head.next.next.next.next.next.next = head;
		System.out.println("LinkedList cycle start: " + StartOfCycle.findCycleStart(head).value);
	}
}