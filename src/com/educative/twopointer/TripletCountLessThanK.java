package com.educative.twopointer;

import java.util.Arrays;
import java.util.List;

public class TripletCountLessThanK {
	
	public static int searchTriplets(int[] arr, int target){
		
		Arrays.sort(arr);
		int count=0;
		for(int i=0; i<arr.length; i++) {
			
			if(i>0 && arr[i]==arr[i-1])
				continue;
			count += getPairWithSum(arr, i+1,target-arr[i]);
		
		}
		
		return count;
	}

	private static int getPairWithSum(int [] arr, int left, int targetSum) {
		int j=arr.length-1;
		int counter=0;
		while(left<j) {
			if(Math.abs((arr[left]+arr[j])) < targetSum) {
				//pairList.add(Arrays.asList(-targetSum, arr[left], arr[j]));
				counter+=j-left;
				left++;
				j--;
			} else {
				j--;
			} 
		}
		return counter;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
	    System.out.println(searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));

	}

}
