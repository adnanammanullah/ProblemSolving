package com.educative.twopointer;

public class FindPairWithSumTarget {
	
	public static int[] search(int[] arr, int targetSum) {
		int [] targets = new int[] {-1, -1};
		int i = 0, j=arr.length-1;
		
		while(i<j) {
			if(arr[i]+arr[j]==targetSum) {
				targets[0] = i;
				targets[1] = j;
				return targets;
			} else if(arr[i]+arr[j]>targetSum) {
				j--;
			} else
				i++;
		}
		return targets;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
