package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoomOne {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));

        int timeTillNow = 0;
        for(int i=0;i<intervals.length;i++) {
            if(timeTillNow > intervals[i][0]) return false;
            timeTillNow = timeTillNow + intervals[i][0] + intervals[i][1];
        }

        return true;
    }

    public static void main(String[] args) {
        int [][] test = new int[3][2];
        test[0][0] = 15;
        test[0][1] = 20;

        test[1][0] = 5;
        test[1][1] = 10;

        test[2][0] = 0;
        test[2][1] = 30;

        MeetingRoomOne meetingRoomOne = new MeetingRoomOne();
        System.out.println(meetingRoomOne.canAttendMeetings(test));
    }
}
