package com.educative.fastSlowPointer;

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

		ListNode middleNode = findMiddle(head);
		ListNode reverseHead = reverseList(middleNode);
		ListNode reverseHeadCopy = reverseHead;
		while (head != null) {
			ListNode next = head.next;
			head.next=reverseHead;
			
			head=next;
			reverseHead=reverseHead.next;
		}

		
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(8);
		head.next.next.next.next = new ListNode(10);
		head.next.next.next.next.next = new ListNode(12);
		reorder(head);
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
	}
}