package com.educative.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordsConcatenation {
	
	public static List<Integer> findWordConcatenation(String str, String[] words) {
		List<Integer> anagramIndices = new ArrayList<Integer>();
		
//		HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
//		for (String w : words) {
//			wordCount.put(w, wordCount.getOrDefault(w, 0)+1);
//		}
//		int matched=0;
//		int windowStart=0;
//		char rightWord, leftWord;
//		for(int windowEnd=0; windowEnd<str.length(); windowEnd++) {
//			rightWord = str.charAt(windowEnd);
//			if(wordCount.containsKey(rightWord)) {
//				wordCount.put(rightWord, wordCount.getOrDefault(rightWord, 0)-1);
//				if(wordCount.getOrDefault(rightWord, 0)==0)
//					matched++;
//			} 
//			
//			if(matched==wordCount.size()) {
//				windowStart = windowEnd-pattern.length()+1;
//				anagramIndices.add(windowStart);
//			}
//			
//			if(windowEnd-windowStart+1 >= pattern.length()) {
//				leftWord = str.charAt(windowStart);
//				if(wordCount.containsKey(leftWord)) {
//					if(wordCount.getOrDefault(leftWord, 0)==0)
//						matched--;
//					wordCount.put(leftWord, wordCount.getOrDefault(leftWord, 0)+1);
//				}
//				windowStart++;
//			}
//		}
		return anagramIndices;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
