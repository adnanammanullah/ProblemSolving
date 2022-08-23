package com.educative.mergeIntervals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InsertIntervals {

	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> mergedIntervals = new ArrayList<>();
		// TODO: Write your code here
		
		if(null==intervals) {
			intervals = new ArrayList<Interval>();
			intervals.add(newInterval);
			return intervals;
		}
		
		Interval interval;
		Iterator<Interval> intervalIterator = intervals.iterator();
		int i;
		
		for(i=0; intervalIterator.hasNext(); i++ ) {
			interval = intervalIterator.next();
			if(interval.start >= newInterval.start) {
				break;
			}
		}
		
		intervals.add(i, newInterval);
		
		intervalIterator = intervals.iterator();
		interval = intervalIterator.next();
		int start=interval.start;
		int end=interval.end;
		while(intervalIterator.hasNext()) {
			interval=intervalIterator.next();
			if(end<interval.start) {
				mergedIntervals.add(new Interval(start, end));
				start=interval.start;
				end=interval.end;
			}else {
				end=Math.max(end, interval.end);
			}
		}
		
		mergedIntervals.add(new Interval(start, end));
		
		return mergedIntervals;
	}

	public static void main(String[] args) {
		List<Interval> input = new ArrayList<Interval>();
		input.add(new Interval(1, 3));
		input.add(new Interval(5, 7));
		input.add(new Interval(8, 12));
		System.out.print("Intervals after inserting the new interval: ");
		for (Interval interval : insert(input, new Interval(4, 6)))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();

		input = new ArrayList<Interval>();
		input.add(new Interval(1, 3));
		input.add(new Interval(5, 7));
		input.add(new Interval(8, 12));
		System.out.print("Intervals after inserting the new interval: ");
		for (Interval interval : insert(input, new Interval(4, 10)))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();

		input = new ArrayList<Interval>();
		input.add(new Interval(2, 3));
		input.add(new Interval(5, 7));
		System.out.print("Intervals after inserting the new interval: ");
		for (Interval interval : insert(input, new Interval(1, 4)))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();
	}

}
