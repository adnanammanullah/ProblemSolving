package com.educative.slidingwindow;
import java.util.HashMap;

public class PermutationInString {
	
	public static boolean findPermutation(String str, String pattern) {
		
		HashMap<Character, Integer> charCount = new HashMap<>();
		//fill hashmap
		for (Character c : pattern.toCharArray()) {
			charCount.put(c, charCount.getOrDefault(c, 0)+1);
		}
		
		boolean isPermuteExist=false;
		int windowStart=0;
		int matched=0;
		
		for(int windowEnd=0; windowEnd<str.length(); windowEnd++) {
			//keep moving with charCount update
			if(charCount.containsKey(str.charAt(windowEnd))) {
				charCount.put(str.charAt(windowEnd), charCount.getOrDefault(str.charAt(windowEnd), 0)-1);
				
				if(charCount.getOrDefault(str.charAt(windowEnd), 0)==0)
					matched++;
			}
			
			if(matched==charCount.size())
				return true;
			
			if(windowEnd-windowStart+1 >= pattern.length()) {
				//shrink the window
				if(charCount.containsKey(str.charAt(windowStart))) {
					if(charCount.getOrDefault(str.charAt(windowStart), 0)==0)
						matched--;
					charCount.put(str.charAt(windowEnd), charCount.getOrDefault(str.charAt(windowEnd), 0)+1);
				}
				windowStart++;
			}
		}
		
		return isPermuteExist;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findPermutation("oidbcaf", "abc"));
		System.out.println(findPermutation("odicf", "dc"));
		System.out.println(findPermutation("bcdxabcdy", "bcdyabcdx"));
		System.out.println(findPermutation("aaacb", "abc"));
		System.out.println(findPermutation("abbc", "abc"));
		System.out.println(findPermutation("a", "xyd"));
	}

}
