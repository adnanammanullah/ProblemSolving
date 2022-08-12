package com.educative.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringKDistinct {

	public static int findLength(String str, int k) {
	    int maxLen=Integer.MIN_VALUE;
	    
	    HashMap<Character, Integer> elementFrequency = new HashMap<>();
	    int windowStart=0;
	    
	    for(int windowEnd=0; windowEnd<str.length(); windowEnd++) {
	    	elementFrequency.put(str.charAt(windowEnd), elementFrequency.getOrDefault(str.charAt(windowEnd), 0)+1);
	    	
	    	while(elementFrequency.size() > k) {
	    		elementFrequency.put(str.charAt(windowStart), elementFrequency.getOrDefault(str.charAt(windowStart), 0)-1);
	    		
	    		if(elementFrequency.getOrDefault(str.charAt(windowStart), 0)==0) {
	    			elementFrequency.remove(str.charAt(windowStart));
	    		}
	    		
	    		windowStart++;
	    	}
	    	
	    	maxLen = Math.max(windowEnd-windowStart+1, maxLen);
	    }
	    return maxLen==Integer.MIN_VALUE?-1:maxLen;
	  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(findLength("abcaaeefgfg", 4));

	}

}
