package com.educative.cylicSort;

public class Problem2 {
	
	public static int smallestPositiveMissing(int [] val) {
		
		int temp, rangeStart=1;
		
		for(int i=0; i<val.length;) {
			if(val[i]>0 && val[i]-rangeStart<val.length && val[i]!=i+rangeStart && val[i]!=val[val[i]-rangeStart]) {
				temp=val[val[i]-rangeStart];
				val[val[i]-rangeStart]=val[i];
				val[i]=temp;
			}else
				i++;
		}
		
 		for(int i=0; i<val.length; i++) {
			if(val[i]!=i+rangeStart)
				return i+rangeStart;
		}
		
		return val.length;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(smallestPositiveMissing(new int[] { -3, 1, 5, 4, 2 }));
	    System.out.println(smallestPositiveMissing(new int[] { 3, -2, 0, 1, 2 }));
	    //System.out.println(smallestPositiveMissing(new int[] { 3, 2, 5, 1 }));
	}

}
