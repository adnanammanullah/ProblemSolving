package com.educative.twopointer;

public class SquareAndSort {
	
	public static int[] makeSquares(int[] arr) {
		int [] squareSorted = new int[arr.length];
		
		int i=0, j=arr.length-1, k=arr.length-1;
		
		while(i<=j) {
			if(arr[i]*arr[i]>arr[j]*arr[j]) {
				squareSorted[k]=arr[i]*arr[i];
				i++;
			}else {
				squareSorted[k]=arr[j]*arr[j];
				j--;
			}
			k--;
		}
		
		return squareSorted;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] result = makeSquares(new int[] { -5, -4, -3, 2, 6 });
	    for (int num : result)
	      System.out.print(num + " ");
	    System.out.println();

	    result = makeSquares(new int[] { -3, -1, 0, 1, 2 });
	    for (int num : result)
	      System.out.print(num + " ");
	    System.out.println();

	}

}
