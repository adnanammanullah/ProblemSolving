package com.educative.fastSlowPointer;

import java.util.HashSet;
import java.util.Set;

public class CycleInCircularArray {
	
	public static boolean loopExists(int[] arr) {
		
		boolean cycleExist=false;
		boolean direction=false;
		Set<Integer> invalidIndices = new HashSet<Integer>();
		Set<Integer> visitedIndices = new HashSet<Integer>();
		
		for(int i=0; i<arr.length && !cycleExist; i++) {
			
			direction=initializeDirection(arr[i]);
			
			for(int j=i; !cycleExist;) {
				if(invalidIndices.contains(j)) {
					break;
				}else if(!validateDirection(direction, arr[j])) {
					break;
				}else if(j==getNextIndex(direction,j, arr[j], arr.length)) {
					break;
				}else if(visitedIndices.contains(j)) {
					cycleExist=true;
				}
				visitedIndices.add(j);
				j=getNextIndex(direction, j, arr[j], arr.length);
			}
			visitedIndices.clear();
			if(!cycleExist)
				invalidIndices.add(i);
		}
		return cycleExist;
	}
	
	private static int getNextIndex(boolean direction, int j, int jValue, int length) {
		return (j+jValue)%length;
	}

	private static boolean validateDirection(boolean direction, int i) {
		if(direction==initializeDirection(i)) {
			return true;
		}else
			return false;
	}

	private static boolean initializeDirection(int i) {
		if(i>=0)
			return true;
		else
			return false;
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(loopExists(new int[] { 1, 2, -1, 2, 2 }));
	    System.out.println(loopExists(new int[] { 2, 2, -1, 2 }));
	    System.out.println(loopExists(new int[] { 2, 1, -1, -2 }));
	    
	    
	}

}
