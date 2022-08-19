package com.educative.slidingwindow;

import java.util.HashMap;

public class SmallestWindowContainingSubStr {
	
	public static String findSubstring(String str, String pattern) {
	    HashMap<Character, Integer> characterCount = new HashMap<Character, Integer>();
	    for(char c : pattern.toCharArray())
	    	characterCount.put(c, characterCount.getOrDefault(c, 0)+1);
	    
	    int windowStart = 0;
	    int minLen=Integer.MAX_VALUE;
	    int startIndex=0, endIndex=0;
	    int matched=0;
	    char rightChar, leftChar;
	    
	    for(int windowEnd=0; windowEnd<str.length(); windowEnd++) {
	    	rightChar = str.charAt(windowEnd);
	    	if(characterCount.containsKey(rightChar)) {
	    		characterCount.put(rightChar, characterCount.getOrDefault(rightChar, 0)-1);

	    		if (characterCount.getOrDefault(rightChar, 0)>=0) {
	    			matched++;
	    		}
	    	}
	    	
	    	while(matched==characterCount.size()) {
	    		if(minLen > windowEnd-windowStart+1) {
	    			minLen = windowEnd-windowStart+1;
	    			startIndex = windowStart;
	    			endIndex = windowEnd;
	    		}
	    		
	    		leftChar = str.charAt(windowStart++);
	    		if(characterCount.containsKey(leftChar)) {
	    			if(characterCount.getOrDefault(leftChar, 0)==0) {
		    			matched--;
		    		}
		    		characterCount.put(leftChar, characterCount.getOrDefault(leftChar, 0)+1);
	    		}
		    	
	    	}
	    	
	    }
	    
	    return minLen==Integer.MAX_VALUE?"":str.substring(startIndex, endIndex+1);
	  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findSubstring("abcbeac", "ac"));
		System.out.println(findSubstring("adcad", "abc"));
	}

}
