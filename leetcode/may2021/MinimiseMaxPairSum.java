package may2021;

import java.util.Arrays;

public class MinimiseMaxPairSum {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int finalSum = Integer.MIN_VALUE;

        for(int i=0;i<(nums.length/2);i++) {
            finalSum = Math.max(finalSum, (nums[i] + nums[nums.length-1-i]));
        }

        return finalSum;
    }
    public static void main(String[] args) {
        int[] test = new int[6];
        test[0] = 3;
        test[1] = 5;
        test[2] = 4;
        test[3] = 2;
        test[4] = 4;
        test[5] = 6;

        int[] test1 = new int[2];
        test1[0] = 1;
        test1[1] = 9;

        MinimiseMaxPairSum minimiseMaxPairSum = new MinimiseMaxPairSum();
        System.out.println(minimiseMaxPairSum.minPairSum(test));
        System.out.println(minimiseMaxPairSum.minPairSum(test1));
    }
}
