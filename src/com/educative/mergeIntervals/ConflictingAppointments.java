package com.educative.mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ConflictingAppointments {

	public static boolean canAttendAllAppointments(Interval[] intervals) {
	    // TODO: Write your code here
		
		Arrays.sort(intervals, (x,y)-> x.start<y.start?-1:1);
		boolean allOk=true;
		int start = intervals[0].start;
		int end = intervals[0].end;
		
		for(int i=1; i<intervals.length && allOk; i++) {
			if(intervals[i].start<end) {
				allOk=false;
			}else {
				start=intervals[i].start;
				end=intervals[i].end;
			}
		}
		
	    return allOk;
	  }

	  public static void main(String[] args) {
	    Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
	    boolean result; 
	    result = canAttendAllAppointments(intervals);
	    System.out.println("Can attend all appointments: " + result);

	    Interval[] intervals1 = { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
	    result = canAttendAllAppointments(intervals1);
	    System.out.println("Can attend all appointments: " + result);

	    Interval[] intervals2 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
	    result = canAttendAllAppointments(intervals2);
	    System.out.println("Can attend all appointments: " + result);
	    
	    Interval [] conflicts;
	    Interval[] intervals3 = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
	    conflicts = getAllConflictingAppointments(intervals3);
	    printConflits(conflicts);

	    Interval[] intervals4 = { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
	    conflicts = getAllConflictingAppointments(intervals4);
	    printConflits(conflicts);

	    Interval[] intervals5 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
	    conflicts = getAllConflictingAppointments(intervals5);
	    printConflits(conflicts);
	  }

	private static void printConflits(Interval[] conflicts) {
		// TODO Auto-generated method stub
		System.out.print("Printing Conflicts :- ");
		for(Interval i : conflicts) {
			System.out.print("("+i.start+","+i.end+"), ");
		}
		System.out.println();
		
	}

	private static Interval[] getAllConflictingAppointments(Interval[] intervals) {
		// TODO Auto-generated method stub
		Set<Interval> mergeIntervals = new HashSet();
		
		Arrays.sort(intervals, (x,y)-> x.start<y.start?-1:1);
		
		int start = intervals[0].start;
		int end = intervals[0].end;
		
		for(int i=1; i<intervals.length; i++) {
			if(intervals[i].start<end) {
				mergeIntervals.add(new Interval(start, end));
				mergeIntervals.add(new Interval(intervals[i].start, intervals[i].start));
			}else {
				start=intervals[i].start;
				end=intervals[i].end;
			}
		}
		
		return mergeIntervals.toArray(new Interval[mergeIntervals.size()]);
	}

}
