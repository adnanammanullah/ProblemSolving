package com.educative.mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

//class Interval {
//  int start;
//  int end;
//
//  public Interval(int start, int end) {
//    this.start = start;
//    this.end = end;
//  }
//};

class EmployeeFreeTime {

  public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
    List<Interval> result = new ArrayList<>();
    
    List<Interval> allWorkingSession = schedule.stream().flatMap(Collection::stream).collect(Collectors.toList());
    Collections.sort(allWorkingSession, (x,y)->x.start<y.start?-1:1);
    PriorityQueue<Interval> workingSession = new PriorityQueue<Interval>((x,y)->x.end<y.end?1:-1);
    
    Iterator<Interval> allWorkingIterator = allWorkingSession.iterator();
    Interval newSession = allWorkingIterator.next();
    workingSession.add(newSession);
    
    while(allWorkingIterator.hasNext()) {
    	newSession = allWorkingIterator.next();
    	if(workingSession.peek().end<newSession.start) {
    		//distinchSessionOccured
    		result.add(new Interval(workingSession.peek().end, newSession.start));
    		workingSession.clear();
    		workingSession.add(newSession);
    	}else {
    		workingSession.add(newSession);
    	}
    }
    
    
    
    
    return result;
  }

  public static void main(String[] args) {

    List<List<Interval>> input = new ArrayList<>();
    input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
    input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
    List<Interval> result = EmployeeFreeTime.findEmployeeFreeTime(input);
    System.out.print("Free intervals: ");
    for (Interval interval : result)
      System.out.print("[" + interval.start + ", " + interval.end + "] ");
    System.out.println();

    input = new ArrayList<>();
    input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
    input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
    input.add(new ArrayList<Interval>(Arrays.asList(new Interval(6, 8))));
    result = EmployeeFreeTime.findEmployeeFreeTime(input);
    System.out.print("Free intervals: ");
    for (Interval interval : result)
      System.out.print("[" + interval.start + ", " + interval.end + "] ");
    System.out.println();

    input = new ArrayList<>();
    input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3))));
    input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
    input.add(new ArrayList<Interval>(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));
    result = EmployeeFreeTime.findEmployeeFreeTime(input);
    System.out.print("Free intervals: ");
    for (Interval interval : result)
      System.out.print("[" + interval.start + ", " + interval.end + "] ");
  }
}
