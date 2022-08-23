package com.educative.fastSlowPointer;

import java.util.ArrayList;
import java.util.List;

class RearrangeLinkedList {

	public static ListNode findMiddle(ListNode head) {
		// TODO: Write your code here
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}

	public static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

	public static void reorder(ListNode head) {
		// TODO: Write your code here
		ListNode headOfFirstHalf = head;
		ListNode middleNode = findMiddle(head);
		ListNode headOfSecondHalf = reverseList(middleNode);
		
		while (headOfFirstHalf != null && headOfSecondHalf!=null) {
			ListNode next1 = headOfFirstHalf.next;
			headOfFirstHalf.next=headOfSecondHalf;
			headOfFirstHalf=next1;
			
			ListNode next2 = headOfSecondHalf.next;
			headOfSecondHalf.next = headOfFirstHalf;
			headOfSecondHalf=next2;
		}
		
		if(headOfFirstHalf != null)
			headOfFirstHalf.next = null;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(8);
		head.next.next.next.next = new ListNode(10);
//		head.next.next.next.next.next = new ListNode(12);

		List<String> arr = new ArrayList<>();
		
		for(String str: arr) {
			
		}
		arr.remove("a");
		ListNode headCopy = head;
		while (headCopy != null) {
			System.out.print(headCopy.value + " ");
			headCopy = headCopy.next;
		}
		
		System.out.println();
		reorder(head);
		
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
	}
}
