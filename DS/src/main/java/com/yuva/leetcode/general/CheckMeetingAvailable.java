package com.yuva.leetcode.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Sample Input : meetings []= { 
 * [1230, 1300], // 12.30PM to 1.00PM 
 * [845, 900] , // 8.45 AM to 9 AM 
 * [1300, 1500] // 1 PM to 3 PM }
 * 
 * Expected Output : isAvailable(meetings, 915, 1215) -> true
 * isAvailable(meetings, 900, 1230) -> true isAvailable(meetings, 850, 1240) ->
 * false
 * 
 * @author Yuvaraja Kanagarajan
 *
    Logic : 
    1. Sort the meetings array based on the start time 
    2. First check whether the given input before the first start or after the
       last end. If then it is available 3. Iterate till input end is lesser
 *         than meetings start
 * 
 */
public class CheckMeetingAvailable {

	static boolean isAvailable(List<int[]> meetings, int new_start, int new_end) {
		
		List<Interval> meetingList = new ArrayList<>();
		for (int[] meeting: meetings) {
			meetingList.add(new Interval (meeting[0], meeting[1]));
		}
		
		Collections.sort(meetingList, (a, b) -> a.start-b.start);
		
		// boundary condition for before the first and after the last
		if (meetingList.get(0).start > new_end || meetingList.get(meetingList.size() - 1).end < new_start) {
			return true;
		}

		Interval prevMeeting = meetingList.get(0);
		for (int i=1; i < meetingList.size(); i++) {
			Interval currMeeting = meetingList.get(i);
			if (new_start >= prevMeeting.end && new_end <= currMeeting.start) {
				return true;
			}
			prevMeeting = currMeeting;
		}
		
		return false;
	}	
	
	public static void main(String[] args) {
		List<int[]> meetings = new ArrayList<int[]>();
		meetings.add(new int[] {1200,1300});
		meetings.add(new int[] {1300,1500});
		meetings.add(new int[] {845,900});
		
		System.out.println(isAvailable(meetings, 915, 1215));
		System.out.println(isAvailable(meetings, 900, 1130));
		System.out.println(isAvailable(meetings, 850, 1240));
		System.out.println(isAvailable(meetings, 850, 1150));
		
	}
}
