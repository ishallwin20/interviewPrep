package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MeetingRoomTwo {

    List<Integer> sortedEndingTimeList = new ArrayList<Integer>();
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int count = 1;
        addToList(intervals[0][1]);
        for(int i =1;i<intervals.length;i++) {
            if(peek() < intervals[i][0]) {
                //This room will get used
                //remove
                remove();
                addToList(intervals[i][1]);
            } else {
                //need new room
                count++;
                addToList(intervals[i][1]);
            }
        }

        return count;
    }

    private void addToList(int a) {
        boolean inserted = false;
        if(sortedEndingTimeList.size() == 0) {
            sortedEndingTimeList.add(a);
            inserted = true;
        }
        else {
            for(int i=0;i<sortedEndingTimeList.size() && !inserted;i++) {
                if(sortedEndingTimeList.get(i) >= a) {
                    sortedEndingTimeList.add(i,a);
                    inserted = true;
                    break;
                }
            }
        }
        if(!inserted) sortedEndingTimeList.add(a);
    }

    private int peek() {
        return sortedEndingTimeList.get(0);
    }

    private void remove() {
        sortedEndingTimeList.remove(0);
    }

    public static void main(String[] args) {
        int [][] test = new int[3][2];
        test[0][0] = 15;
        test[0][1] = 20;

        test[1][0] = 5;
        test[1][1] = 10;

        test[2][0] = 0;
        test[2][1] = 30;

        MeetingRoomTwo meetingRoomTwo = new MeetingRoomTwo();
        System.out.println(meetingRoomTwo.minMeetingRooms(test));

        /*meetingRoomTwo.addToList(10);
        meetingRoomTwo.addToList(1);
        meetingRoomTwo.addToList(2);
        meetingRoomTwo.addToList(-1);
        meetingRoomTwo.addToList(100);*/
    }
}
