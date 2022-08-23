package com.educative.fastSlowPointer;

class PalindromeLinkedList {

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
		while(head!=null) {
			ListNode next = head.next;
			head.next=prev;
			prev=head;
			head=next;
		}
		return prev;
	}

	public static boolean isPalindrome(ListNode head) {
		// TODO: Write your code here
		
		ListNode middleNode = findMiddle(head);
		ListNode reverseHead = reverseList(middleNode);
		ListNode reverseHeadCopy = reverseHead;
		
		while(head!=null && reverseHeadCopy!=null) {
			if(head.value!=reverseHeadCopy.value) {
				break;
			}
			head=head.next;
			reverseHeadCopy=reverseHeadCopy.next;
		}
		
		reverseList(reverseHead);
		
		if(null==reverseHeadCopy || null==head)
			return true;
		return false;
	}

	public static void main(String[] args) {
		 ListNode head = new ListNode(2);
		    head.next = new ListNode(4);
		    head.next.next = new ListNode(6);
		    head.next.next.next = new ListNode(4);
		    head.next.next.next.next = new ListNode(2);
		    System.out.println("Is palindrome: " + isPalindrome(head));

		    head.next.next.next.next.next = new ListNode(2);
		    System.out.println("Is palindrome: " + isPalindrome(head));
		    
	}
}