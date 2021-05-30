package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        int prev_index = 0;
        int count = 1;
        int prev_maxBoundary = intervals[0][1];
        for(int i=1;i<intervals.length;i++) {
            if(prev_maxBoundary >= intervals[i][0]) {
                prev_maxBoundary = Math.max(prev_maxBoundary, intervals[i][1]);
                intervals[prev_index][1] = prev_maxBoundary;
            } else {
                prev_index ++;
                intervals[prev_index][0] = intervals[i][0];
                intervals[prev_index][1] = intervals[i][1];
                count ++;
                prev_maxBoundary = intervals[i][1];
            }
        }

        return Arrays.copyOf(intervals,count);
    }
    public static void main(String[] args) {
        int [][] test = new int[4][2];
        test[0][0] = 10;
        test[0][1] = 12;

        test[1][0] = 2;
        test[1][1] = 6;

        test[2][0] = 3;
        test[2][1] = 4;

        test[3][0] = 1;
        test[3][1] = 3;

        MergeIntervals mergeIntervals = new MergeIntervals();
        mergeIntervals.merge(test);
    }
}
