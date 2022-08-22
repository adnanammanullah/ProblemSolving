package com.educative.twopointer;

public class MinimumWindowSort {
	
	public static int sort(int[] arr) {
		int left=0, right=arr.length-1;
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		
		while(left<arr.length-1 && arr[left]<arr[left+1]) {
			left++;
		}
		
		while(right>1 && arr[right]>arr[right-1]) {
			right--;
		}
		//find min and max
		for(int i=left; i<=right; i++ ) {
			if(arr[i]<min)
				min=arr[i];
			if(arr[i]>max)
				max=arr[i];
		}
		
		for(int i=left-1; i>=0; i--) {
			if(arr[i]>min) {
				left=i;
			}
		}
		
		for(int i=right+1; i<arr.length; i++) {
			if(arr[i]<max) {
				right=i;
			}
		}
		
		return right-left+1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
