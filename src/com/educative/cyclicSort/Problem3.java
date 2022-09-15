package com.educative.cyclicSort;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {

	public static List<Integer> findKMissingNum(int [] val, int k){
		List<Integer> missingNum = new ArrayList<>();
		int temp;
		int rangeStart=1;
		for(int i=0; i<val.length; ) {
			if(val[i]>0 && val[i]-rangeStart<val.length && val[i]!=i+rangeStart && val[i]!=val[val[i]-rangeStart] ) {
				temp=val[val[i]-rangeStart];
				val[val[i]-rangeStart]=val[i];
				val[i]=temp;
			}else
				i++;
		}
		
		for(int i=0; i<val.length && k>0; i++) {
			if(val[i]!=i+rangeStart) {
				missingNum.add(i+rangeStart);
				k--;
			}
		}
		
		for(int i=val[val.length-1]+1; k>0; i++) {
			missingNum.add(i);
			k--;
		}
		
		return missingNum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> missingNumbers = findKMissingNum(new int[] { 3, -1, 4, 5, 5 }, 3);
	    System.out.println("Missing numbers: " + missingNumbers);

	    missingNumbers = findKMissingNum(new int[] { 2, 3, 4 }, 3);
	    System.out.println("Missing numbers: " + missingNumbers);

	    missingNumbers = findKMissingNum(new int[] { -2, -3, 4 }, 4);
	    System.out.println("Missing numbers: " + missingNumbers);
	}

}
