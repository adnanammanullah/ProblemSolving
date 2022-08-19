package com.educative.twopointer;

public class RemoveDuplicates {
	
	public static int remove(int[] arr) {
		int i=0,j=0;
		
		while(j<arr.length) {
			if(arr[i]!=arr[j])
				arr[++i]=arr[j];
			j++;
		}
		
		return i+1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
	    System.out.println(RemoveDuplicates.remove(arr));
	    
	    arr = new int[] { 2, 2, 2, 11 };
	    System.out.println(RemoveDuplicates.remove(arr));
	}

}
