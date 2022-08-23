package com.educative.mergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ProduceMutuallyExclusiveIntervals {

	public static List<Interval> merge(List<Interval> intervals) {
		List<Interval> mergedIntervals = new LinkedList<Interval>();
		
		if(null==intervals)
			return mergedIntervals;
		else if(intervals.size()<=1)
			return intervals;
		
		Collections.sort(intervals, (x, y) -> x.start<y.start?-1:1);
//		printIntervals(intervals);
		
		int start=intervals.get(0).start;
		int end=intervals.get(0).end;
		
		for(int i=1; i<intervals.size(); i++) {
			if(end<intervals.get(i).start) {
				mergedIntervals.add(new Interval(start, end));
				start=intervals.get(i).start;
				end=intervals.get(i).end;
			} else {
				end=Math.max(intervals.get(i).end, end);
			}
		}
		
		mergedIntervals.add(new Interval(start, end));
		
		return mergedIntervals;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Interval> input = new ArrayList<Interval>();
		List<Interval> exclusiveInterval;
		input.add(new Interval(1, 4));
		input.add(new Interval(2, 5));
		input.add(new Interval(7, 9));
		exclusiveInterval = merge(input);
		printIntervals(exclusiveInterval);

		input = new ArrayList<Interval>();
		input.add(new Interval(6, 7));
		input.add(new Interval(2, 4));
		input.add(new Interval(5, 9));
		
		exclusiveInterval = merge(input);
		printIntervals(exclusiveInterval);

		input = new ArrayList<Interval>();
		input.add(new Interval(1, 4));
		input.add(new Interval(2, 6));
		input.add(new Interval(3, 5));
		
		exclusiveInterval = merge(input);
		printIntervals(exclusiveInterval);

	}

	private static void printIntervals(List<Interval> input) {
		System.out.print("Merged intervals: ");
		for (Interval interval : input)
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();
	}

}
