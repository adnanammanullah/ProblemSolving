package com.educative.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindSubStrAnagram {
	
	public static List<Integer> findStringAnagrams(String str, String pattern) {
		List<Integer> anagramIndices = new ArrayList<Integer>();
		
		HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();
		for (char c : pattern.toCharArray()) {
			charCount.put(c, charCount.getOrDefault(c, 0)+1);
		}
		int matched=0;
		int windowStart=0;
		char rightChar, leftChar;
		for(int windowEnd=0; windowEnd<str.length(); windowEnd++) {
			rightChar = str.charAt(windowEnd);
			if(charCount.containsKey(rightChar)) {
				charCount.put(rightChar, charCount.getOrDefault(rightChar, 0)-1);
				if(charCount.getOrDefault(rightChar, 0)==0)
					matched++;
			} 
			
			if(matched==charCount.size()) {
				windowStart = windowEnd-pattern.length()+1;
				anagramIndices.add(windowStart);
			}
			
			if(windowEnd-windowStart+1 >= pattern.length()) {
				leftChar = str.charAt(windowStart);
				if(charCount.containsKey(leftChar)) {
					if(charCount.getOrDefault(leftChar, 0)==0)
						matched--;
					charCount.put(leftChar, charCount.getOrDefault(leftChar, 0)+1);
				}
				windowStart++;
			}
		}
		return anagramIndices;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(findStringAnagrams("abbcabc", "abc"));

	}

}
