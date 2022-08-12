package com.educative.slidingwindow;

public class LongestSameSubStrWithReplacement {
	
	public static int findLength(String str, int k) {
		
		int maxLen = Integer.MIN_VALUE;
		int windowStart=0;
		int maxCharCount = Integer.MIN_VALUE;
		HashMap<Character, Integer> charCount = new HashMap<>();
		
		for(int windowEnd=0; windowEnd<str.length(); windowEnd++) {
 			charCount.put(str.charAt(windowEnd), charCount.getOrDefault(str.charAt(windowEnd), 0)+1);
 			if(maxCharCount<charCount.getOrDefault(str.charAt(windowEnd), 0))
 				maxCharCount = charCount.getOrDefault(str.charAt(windowEnd), 0);
 			
 			while(windowEnd-windowStart+1-maxCharCount > k ) {
 				charCount.put(str.charAt(windowStart), charCount.getOrDefault(str.charAt(windowStart), 0)-1);
 				
 				if(charCount.getOrDefault(str.charAt(windowStart), 0)==0)
 					charCount.remove(str.charAt(windowStart));
 				windowStart++;
 			}
 			if(windowEnd-windowStart+1 > maxLen)
 				maxLen = windowEnd-windowStart+1;  
		}
		
		return maxLen==Integer.MIN_VALUE?-1:maxLen;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(findLength("aabbcb", 1));
	}

}
