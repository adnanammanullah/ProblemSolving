package com.educative.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubarrayProductLessThanTarget {
	
	public static List<List<Integer>> findSubarrays(int[] arr, int target) {
		
		List<Integer> pairList = new ArrayList<Integer>();
		List<List<Integer>> allLists = new ArrayList<List<Integer>>();
		Set<List<Integer>> allSets = new HashSet<List<Integer>>();
		int product = 1;
		int i=0, j=0;
		while(i<arr.length || j<arr.length) {
			
			if(i==j && !(arr[j]<target)) {
				i++;
				j++;
				continue;
			}
			if(j<arr.length && product*arr[j]<target) {
				product = product*arr[j];
				pairList.add(arr[j]);
				allSets.add(new ArrayList(pairList));
				j++;
			} else {
				product=product/arr[i];
				pairList.remove((Integer)arr[i]);
				if(i>0 && arr[i]<target)
					allSets.add(Arrays.asList(arr[i]));
				i++;
			}
		
		}
		allSets.forEach(x -> allLists.add(x));
		return allLists;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
		System.out.println(findSubarrays(new int[] { 2, 5, 3, 10 }, 30));

	}
	

}
