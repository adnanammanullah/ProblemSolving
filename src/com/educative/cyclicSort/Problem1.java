package com.educative.cylicSort;

public class Problem1 {
	
	public static int[] findCorruptNumbers(int[] val) {
		int range_start=1;
		int temp;
		for(int i=0; i<val.length;) {
			if(val[i]-range_start<val.length && val[i]!=i+range_start && val[i]!=val[val[i]-range_start]) {
				temp = val[val[i]-range_start];
				val[val[i]-range_start]=val[i];
				val[i]=temp;
			}else
				i++;
		}
		
		for(int i=0; i<val.length; i++) {
			if(val[i]!=i+range_start) {
				return new int[] {val[i], i+range_start};
			}
		}
		
		return new int[] {-1,-1};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = findCorruptNumbers(new int[] { 3, 1, 2, 5, 2 });
	    System.out.println(nums[0] + ", " + nums[1]);
	    nums = findCorruptNumbers(new int[] { 3, 1, 2, 3, 6, 4 });
	    System.out.println(nums[0] + ", " + nums[1]);
	}

}
