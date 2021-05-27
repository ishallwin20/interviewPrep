package dp;

public class MaxSubArraySum {
    public int maxSubArray(int[] nums) {
        int[] sumArr = new int[nums.length];
        int out = Integer.MIN_VALUE;
        sumArr[0] = nums[0];
        for(int i=1;i<nums.length;i++) {
            sumArr[i] = Math.max(nums[i],nums[i] + sumArr[i-1]);
            out = Math.max(out, sumArr[i]);
        }

        return out;

    }
    public static void main(String[] args) {
        int[] test = new int[9];
        test[0]= -2;
        test[1]= 1;
        test[2]= -3;
        test[3]= 4;
        test[4]= -1;
        test[5]= 2;
        test[6]= 1;
        test[7]= -5;
        test[8]= 4;

        MaxSubArraySum maxSubArraySum = new MaxSubArraySum();

        System.out.println(maxSubArraySum.maxSubArray(test));
    }
}
