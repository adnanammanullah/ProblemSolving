package com.educative.cyclicSort;

public class DuplicateWithCircularList {
	
	public static int findDuplicateNum(int[] nums) {
		
		//if there is circle in the list, both the pointer will definately be same at one point!
		int slow=0; int fast=0;
		do {
			slow=nums[slow];
			fast=nums[nums[fast]];
		}while(slow!=fast);
		
		//find the length of the circle this will be used to identify the start of the circle
		//i.e. the repeating element
		
		int current=nums[slow];
		int length=0;
		
		do {
			current=nums[current];
			length++;
		}while(current!=slow);
		
		//now that we have a length of the circle, so firstly we will move one pointer ahead by length 
		//from start and the will use that pointer to find the start of the circle.
		fast=0;
		while(length>0) {
			fast=nums[fast];
			length--;
		}
		
		//now as mentioned above we will go for start of the circle that is our repeating number
		
		slow=0;
		while(fast!=slow) {
			fast=nums[fast];
			slow=nums[slow];
		}
		
		return nums[fast];
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findDuplicateNum(new int[] { 1, 4, 4, 3, 2 }));
	    System.out.println(findDuplicateNum(new int[] { 2, 1, 3, 3, 5, 4 }));
	    System.out.println(findDuplicateNum(new int[] { 2, 4, 1, 4, 4 }));
	}

}
