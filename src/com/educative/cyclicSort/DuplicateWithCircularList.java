package com.educative.cyclicSort;

public class DuplicateWithCircularList {
	
	public static int findDuplicate(int [] val) {
		
		int slow=0, fast=0;
		do {
			
			slow=val[slow];
			fast=val[val[fast]];
			
		}while(slow!=fast);
		
		int lenght=0;
		int current=slow;
		
		do {
			lenght++;
			current=val[current];
		} while(current!=slow);
		
		int temp=0;
		
		while(lenght>0) {
			lenght--;
			temp=val[temp];
		}
		
		int temp2 = 0;
		
		while(temp2!=temp) {
			temp2=val[temp2];
			temp=val[temp];
		}
		
		return temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findDuplicate(new int[] { 1, 4, 4, 3, 2 }));
		System.out.println(findDuplicate(new int[] { 2, 1, 3, 3, 5, 4 }));
		System.out.println(findDuplicate(new int[] { 2, 4, 1, 4, 4 }));	
	}
}
