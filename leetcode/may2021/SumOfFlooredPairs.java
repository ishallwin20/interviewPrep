package may2021;

import java.util.Arrays;

public class SumOfFlooredPairs {

    public int sumOfFlooredPairs(int[] nums) {
        Arrays.sort(nums);

        int sum = 1;
        for(int i=1;i<nums.length;i++) {
            for(int j=i; j>=0;j--) {
                sum += (nums[i]/nums[j]);
                sum = sum % (1000000007);
            }
        }

        return sum;
    }
    public static void main(String[] args) {
        int[] test = new int[7];
        test[0] = 7;
        test[1] = 7;
        test[2] = 7;
        test[3] = 7;
        test[4] = 7;
        test[5] = 7;
        test[6] = 7;

        SumOfFlooredPairs s = new SumOfFlooredPairs();
        s.sumOfFlooredPairs(test);
    }
}
