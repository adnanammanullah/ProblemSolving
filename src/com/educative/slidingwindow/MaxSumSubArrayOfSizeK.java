package com.educative.slidingwindow;

public class MaxSumSubArrayOfSizeK {
	
	public static int findMaxSumSubArray(int k, int[] arr) {
		int maxSum=Integer.MIN_VALUE;
		int sum=0;
		
		if(arr.length<k || k<=0)
			return -1;
		else {
			for(int i=0; i<k; i++) {
				sum+=arr[i];
			}
			
			if(sum>maxSum)
				maxSum=sum;
			
			for(int i=k; i<arr.length; i++) {
				sum+=arr[i];
				sum-=arr[i-k];
				if(sum>maxSum)
					maxSum=sum;
			}
		}
		return maxSum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
