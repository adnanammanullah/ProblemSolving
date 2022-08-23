package com.educative.fastSlowPointer;

class MiddleOfLinkedList {

  public static ListNode findMiddle(ListNode head) {
    // TODO: Write your code here
    ListNode slow=head, fast=head;
    while(fast != null && fast.next != null) {
    	fast = fast.next.next;
    	slow = slow.next;
    }
    
    return slow;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);

    head.next.next.next.next.next = new ListNode(6);
    System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);

    head.next.next.next.next.next.next = new ListNode(7);
    System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);
    
    head.next.next.next.next.next.next.next = new ListNode(8);
    System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);
  }
}