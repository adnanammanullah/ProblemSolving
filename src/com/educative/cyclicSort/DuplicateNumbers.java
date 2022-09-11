package com.educative.cyclicSort;

public class DuplicateNumbers {
	
	public static int findDubplicateNum(int[] nums) {
		
		int temp;
		for(int i=0; i<nums.length; ) {
			if(nums[i]<nums.length && nums[i]!=i+1) {
				if(nums[i]==nums[nums[i]-1]) {
					return nums[i];
				}
				temp=nums[nums[i]-1];
				nums[nums[i]-1]=nums[i];
				nums[i]=temp;
				
			}else {
				i++;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findDubplicateNum(new int[] { 1,4,4,3,2 }));
		System.out.println(findDubplicateNum(new int[] { 2, 1, 3, 3, 5, 4 }));
	}

}
