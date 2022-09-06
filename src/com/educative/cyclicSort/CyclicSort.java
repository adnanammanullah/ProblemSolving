package com.educative.cyclicSort;

import java.util.Arrays;

public class CyclicSort {

	public static void sort(int[] nums) {
		int temp=0;
		for(int i=0; i<nums.length;) {
			if(nums[i]-1==i) {
				i++;
			}else {
				temp=nums[nums[i]-1];
				nums[nums[i]-1]=nums[i];
				nums[i]=temp;
			}
		}
	}
	
	public static void sort(int[] nums, int target) {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = new int[] {5,3,2,1,4};
		sort(nums);
		System.out.println(Arrays.toString(nums));

	}

}
