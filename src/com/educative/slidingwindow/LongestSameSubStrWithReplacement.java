package com.educative.slidingwindow;

public class LongestSameSubStrWithReplacement {
	
	public static int findLength(String str, int k) {
		
		int maxLen = Integer.MIN_VALUE;
		int kk=k;
		int windowStart=0;
		int firstRepIndex=0;
		
		for(int windowEnd=0; windowEnd<str.length(); windowEnd++) {
 			while((windowEnd<str.length() && str.charAt(windowStart)==str.charAt(windowEnd)) || kk>0) {
				if(str.charAt(windowStart)!=str.charAt(windowEnd)) {
					kk--;
					if(firstRepIndex==0) {
						firstRepIndex=windowEnd;
					}
				}
				
				if(maxLen<windowEnd-windowStart+1) {
					maxLen=windowEnd-windowStart+1;
				}
				windowEnd++;
			}
			
			windowStart=firstRepIndex;
			firstRepIndex=0;
			kk=k;
		}
		
		return maxLen==Integer.MIN_VALUE?-1:maxLen;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(findLength("aabbcb", 1));
	}

}
