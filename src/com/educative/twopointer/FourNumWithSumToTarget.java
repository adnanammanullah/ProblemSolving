package com.educative.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourNumWithSumToTarget {
	
	public static List<List<Integer>> fourNumSumToTarget(int[] arr, int target){
		List<List<Integer>> output = new ArrayList<>();
		
		Arrays.sort(arr);
		
		for(int i=0; i<arr.length; i++) {
			
			if(i>0 && arr[i]==arr[i-1])
				continue;
			searchTriplets(arr, i,target-arr[i], output);
		
		}
		
		return output;
	}
	
	public static List<List<Integer>> searchTriplets(int[] arr, int left, int target, List<List<Integer>> output) {
		
		for(int i=left+1; i<arr.length; i++) {
			
			if(i>0 && arr[i]==arr[i-1])
				continue;
			getPairWithSum(arr, arr[left], i,target-arr[i], output);
		
		}
		
		return output;
	}

	private static List<List<Integer>> getPairWithSum(int [] arr, int gParent, int left, int targetSum, List<List<Integer>> pairList) {
		int j=arr.length-1;
		int parent=arr[left++];
		while(left<j) {
			if(arr[left]+arr[j]==targetSum) {
				pairList.add(Arrays.asList(gParent, parent, arr[left], arr[j]));
				left++;
				j--;
			} else if(arr[left]+arr[j]>targetSum) {
				j--;
			} else
				left++;
		}
		return pairList;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fourNumSumToTarget(new int[] { 4, 1, 2, -1, 1, -3 }, 1));
		System.out.println(fourNumSumToTarget(new int[] { 2, 0, -1, 1, -2, 2 }, 2));
	}

}
