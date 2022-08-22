package com.educative.twopointer;

import java.util.Arrays;

public class DutchFlagProblem {
	
	public static void sort(int[] arr) {
		int high=arr.length-1;
		int low=0;
		
		for(int i=0; i<=high;) {
			if(arr[i]==0) {
				//swap with low
				swap(arr, i, low);
				i++;
				low++;
			}else if(arr[i]==1) {
				i++;
			}else {
				//swap with high
				swap(arr, i, high);
				high--;
			}
		}
	}
	
	public static void swap(int [] arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = new int[] { 1, 0, 2, 1, 0 };
		sort(arr);
		System.out.println(Arrays.toString(arr));
		
		int [] arr2 = new int[] { 0, 2, 2, 1, 0 };
		sort(arr2);
		System.out.println(Arrays.toString(arr2));

	}

}
