package com.educative.mergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {

	public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
		List<Interval> mergeIntervals = new ArrayList<Interval>();
		// TODO: Write your code here
		
		int i,j;
		
		for(i=0, j=0; i<arr1.length && j<arr2.length; ) {
			if(arr1[i].start<=arr2[j].start) {
				if(arr1[i].end>=arr2[j].start) {
					mergeIntervals.add(new Interval(arr2[j].start, Math.min(arr1[i].end, arr2[j].end)));
				}
				i++;
			}else {
				if(arr2[j].end>=arr1[i].start) {
					mergeIntervals.add(new Interval(arr1[i].start, Math.min(arr1[i].end, arr2[j].end)));
				}
				j++;
			}
		}	
		
		return mergeIntervals.toArray(new Interval[mergeIntervals.size()]);
	}

	public static void main(String[] args) {
		Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
		Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
		Interval[] result = merge(input1, input2);
		System.out.print("Intervals Intersection: ");
		for (Interval interval : result)
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();

		input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
		input2 = new Interval[] { new Interval(5, 10) };
		result = merge(input1, input2);
		System.out.print("Intervals Intersection: ");
		for (Interval interval : result)
			System.out.print("[" + interval.start + "," + interval.end + "] ");
	}

}
