package com.educative.cylicSort;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicate {
	
	public static List<Integer> findNumbers(int[] val) {
		List<Integer> duplicateNum = new ArrayList<>();
		int temp;
		int range_start=1;
		for(int i=0; i<val.length; ) {
			if(val[i]-range_start<val.length && val[i]!=i+range_start && val[i]!=val[val[i]-range_start]) {
				temp = val[val[i]-range_start];
				val[val[i]-range_start]=val[i];
				val[i]=temp;
			}else
				i++;
		}
		
		for(int i=0; i<val.length; i++) {
			if(val[i]!=i+range_start) {
				duplicateNum.add(val[i]);
			}
		}
		
		return duplicateNum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> duplicates = FindAllDuplicate.findNumbers(new int[] { 3, 4, 4, 5, 5 });
	    System.out.println("Duplicates are: " + duplicates);

	    duplicates = FindAllDuplicate.findNumbers(new int[] { 5, 4, 7, 2, 3, 5, 3 });
	    System.out.println("Duplicates are: " + duplicates);
	}

}
