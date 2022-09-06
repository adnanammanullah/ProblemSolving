package com.educative.cyclicSort;

public class MissingNumber {
	
	 public static int findMissingNumber(int[] nums) {
		 int temp=-1;
		 int missingNum=-1;
		 for(int i=0; i< nums.length; ) {
			 if(nums[i]<nums.length && nums[i]!=i) {
				 temp=nums[nums[i]];
				 nums[nums[i]]=nums[i];
				 nums[i]=temp;
			 }else
				 i++;
		 }
		 for(int i=0; i<nums.length; i++) {
			 if(nums[i]!=i) {
				 return i;
			 }
		 }
		 return nums.length;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(MissingNumber.findMissingNumber(new int[] { 4, 0, 3, 1 }));
	    System.out.println(MissingNumber.findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
	}

}
