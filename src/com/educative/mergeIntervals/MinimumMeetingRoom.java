package com.educative.mergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumMeetingRoom {

	public static int findMinimumMeetingRooms(List<Interval> meetings) {
		Collections.sort(meetings, (x, y) -> x.start < y.start ? -1 : 1);

		Iterator<Interval> intervalIterator = meetings.iterator();
		Interval newMeeting = intervalIterator.next();
		
		PriorityQueue<Integer> onGoingRoomMeeting = new PriorityQueue<Integer>();
		onGoingRoomMeeting.add(newMeeting.end);
		int roomCount = onGoingRoomMeeting.size();

		while (intervalIterator.hasNext()) {
			newMeeting = intervalIterator.next();
			if (newMeeting.start < onGoingRoomMeeting.peek()) {
				onGoingRoomMeeting.add(newMeeting.end);
			} else {
				while(!onGoingRoomMeeting.isEmpty() && onGoingRoomMeeting.peek()<=newMeeting.start)
					onGoingRoomMeeting.poll();
				onGoingRoomMeeting.add(newMeeting.end);
			}
			roomCount = Math.max(onGoingRoomMeeting.size(),roomCount);	
		}

		return roomCount;
	}

	public static void main(String[] args) {

		ArrayList<Interval> input = new ArrayList<Interval>() {
			{
				add(new Interval(4, 5));
				add(new Interval(2, 3));
				add(new Interval(2, 4));
				add(new Interval(3, 5));
			}
		};
		int result = findMinimumMeetingRooms(input);
		System.out.println("Minimum meeting rooms required: " + result);

		input = new ArrayList<Interval>() {
			{
				add(new Interval(1, 4));
				add(new Interval(2, 5));
				add(new Interval(7, 9));
			}
		};
		result = findMinimumMeetingRooms(input);
		System.out.println("Minimum meeting rooms required: " + result);

		input = new ArrayList<Interval>() {
			{
				add(new Interval(6, 7));
				add(new Interval(2, 4));
				add(new Interval(8, 12));
			}
		};
		result = findMinimumMeetingRooms(input);
		System.out.println("Minimum meeting rooms required: " + result);

		input = new ArrayList<Interval>() {
			{
				add(new Interval(1, 4));
				add(new Interval(2, 3));
				add(new Interval(3, 6));
			}
		};
		result = findMinimumMeetingRooms(input);
		System.out.println("Minimum meeting rooms required: " + result);

		input = new ArrayList<Interval>() {
			{
				add(new Interval(4, 5));
				add(new Interval(2, 3));
				add(new Interval(2, 4));
				add(new Interval(3, 5));
			}
		};
		result = findMinimumMeetingRooms(input);
		System.out.println("Minimum meeting rooms required: " + result);
	}

}
