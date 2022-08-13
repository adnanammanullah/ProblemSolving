package com.educative.slidingwindow;
import java.util.HashMap;

public class LongestSubArrayWithOnesAfterRep {
	
	public static int findLength(int[] arr, int k) {
		int maxLen = Integer.MIN_VALUE;
		
		int windowStart = 0;
		int maxOnes = Integer.MIN_VALUE;
		HashMap<Integer, Integer> numCount = new HashMap<>();
		
		for(int windowEnd=0; windowEnd<arr.length; windowEnd++) {
			numCount.put(arr[windowEnd], numCount.getOrDefault(arr[windowEnd], 0)+1);
			if(maxOnes < numCount.getOrDefault(1, 0))
				maxOnes = numCount.getOrDefault(1, 0);
			
			while(windowEnd-windowStart+1-maxOnes > k) {
				numCount.put(arr[windowStart], numCount.getOrDefault(arr[windowStart], 0)-1);
				
				if(numCount.getOrDefault(arr[windowStart], 0)==0)
					numCount.remove(arr[windowStart]);
				
				windowStart++;
			}
			
			if(maxLen < windowEnd-windowStart+1)
				maxLen = windowEnd-windowStart+1;
		}
		
		
		return maxLen==Integer.MIN_VALUE?-1:maxLen;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findLength(new int[] {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3));
	}

}
