package slidingwindow;

public class MinSizeSubarrSum {
    public int minSubArrayLen(int target, int[] nums) {
        /*
        TWO POINTER APPROACH IN SLIDING WINDOW

        keep moving two pointers as you check sum each time wrt target and move your next pointers accordingly
         */
        int minLength = Integer.MAX_VALUE;
        int runningSum = nums[0];
        for(int i=0,j=0;;){
            if(runningSum > target){
                //This below part added for >= target that was demanded in the question
                if(minLength>(j-i+1)) minLength = (j-i+1);
                if(minLength == 1) return 1;
                //till here
                if(i==j) {
                    i++;
                    j++;
                    if(i == nums.length) break;
                    runningSum = nums[i];
                } else{
                    runningSum -= nums[i];
                    i++;
                }
            } else if(runningSum == target) {
                if(minLength>(j-i+1)) minLength = (j-i+1);
                if(minLength == 1) return 1;
                i++;
                j++;
                if(i == nums.length || j == nums.length) break;
                runningSum = runningSum - nums[i-1] + nums[j];
            } else {
                j++;
                if(j == nums.length) break;
                runningSum += nums[j];
            }
            if(i == nums.length || j == nums.length) break;
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
    public static void main(String[] args) {
        int[] test = new int[7];
        test[0] = 10;
        test[1] = 2;
        test[2] = 3;
        test[3] = 1;
        test[4] = 2;
        test[5] = 4;
        test[6] = 3;
        MinSizeSubarrSum minSizeSubarrSum = new MinSizeSubarrSum();
        System.out.println(minSizeSubarrSum.minSubArrayLen(7,test));
    }
}
