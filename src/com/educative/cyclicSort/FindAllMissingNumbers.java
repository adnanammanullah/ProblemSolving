package com.educative.cyclicSort;

import java.util.ArrayList;
import java.util.List;

public class FindAllMissingNumbers {

	public static List<Integer> findNumbers(int[] nums) {
		List<Integer> missingNumbers = new ArrayList<>();
		// TODO: Write your code here
		int temp;
		for(int i=0; i<nums.length; ) {
			if(nums[i]-1 < nums.length && nums[i]!=i+1 && nums[i]!=nums[nums[i]-1]) {
				temp = nums[nums[i]-1];
				nums[nums[i]-1]=nums[i];
				nums[i]=temp;
				
			}else
				i++;
		}
		
		for(int i=0; i<nums.length; i++) {
			if(nums[i]!=i+1) {
				missingNumbers.add(i+1);
			}
		}
		
		return missingNumbers;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findNumbers(new int[] { 4, 3, 1 }));
	    System.out.println(findNumbers(new int[] { 3, 3, 3, 3, 1, 4, 6, 1 }));
	}

}
