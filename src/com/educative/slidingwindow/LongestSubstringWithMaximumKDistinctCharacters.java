package com.educative.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithMaximumKDistinctCharacters {
	
	public static int findLength(String str, int k) {
	
		Set<String> char_set = new HashSet<>();
		
		int maxLength = Integer.MIN_VALUE;
		int windowStart=0;
		
		for(int windowEnd=0; windowEnd<str.length(); windowEnd++) {
			
			char_set.add(String.valueOf(str.charAt(windowEnd)));
			
			if(char_set.size()<=k) {
				if(windowEnd-windowStart+1 > maxLength)
					maxLength = windowEnd-windowStart+1;
			}
			
			else {
				while(str.charAt(windowStart)==str.charAt(windowStart+1) && windowStart<str.length()-1)
					windowStart++;
				char_set.remove(String.valueOf(str.charAt(windowStart)));
				windowStart++;
			}
		}
		
		return maxLength;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findLength("cbbebi",2));
	}

}
