package com.educative.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrippletSumCloseToTarget {
	
	public static int searchTriplets(int[] arr, int targetSum) {
		
		Arrays.sort(arr);
		List<Integer> pairList;
		int minDiff = Integer.MAX_VALUE;
		for(int i=0; i<arr.length; i++) {
			
			if(i>0 && arr[i]==arr[i-1])
				continue;
			minDiff = getPairWithSum(arr, i+1,targetSum-arr[i], minDiff);
		
		}
		
		return targetSum-minDiff;
	}

	private static int getPairWithSum(int [] arr, int left, int targetSum, int minDiff) {
		int j=arr.length-1;
		while(left<j) {
			if(Math.abs(targetSum-(arr[left]+arr[j])) < minDiff) {
				minDiff = Math.abs(targetSum-(arr[left]+arr[j]));
				left++;
				j--;
			} else if(arr[left]+arr[j]>targetSum) {
				j--;
			} else
				left++;
		}
		return minDiff;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }, 5));
//		[[-3, 1, 2], [-2, 1, 1], [-2, 0, 2], [-1, 0, 1]]

	}
	

}
