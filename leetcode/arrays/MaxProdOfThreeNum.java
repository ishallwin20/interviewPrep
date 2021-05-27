package arrays;

import java.util.Arrays;

public class MaxProdOfThreeNum {
    public int maximumProduct_sorting(int[] nums) {
        Arrays.sort(nums);
        return Math.max((nums[nums.length-1] * nums[nums.length-2] * nums[nums.length-3]),(nums[nums.length-1] * nums[0] * nums[1]));
    }

    public int maximumProduct(int[] nums) {
        //Greedy Approach
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int num : nums) {
            if(num > max1) {
                int temp = max1;
                int temp2 = max2;
                max1 = num;
                max2 = temp;
                max3 = temp2;
            } else if(num > max2) {
                int temp = max2;
                max2 = num;
                max3 = temp;
            } else if(num > max3 ) {
                max3 = num;
            }

            if(num < min1) {
                int temp = min1;
                min1 = num;
                min2 = temp;
            } else if(num < min2) {
                min2 = num;
            }


        }

        return Math.max(min1 * min2 * max1 , max1 * max2 * max3);
    }

    public static void main(String[] args) {
        int [] test1 = new int[4];
        test1[0] = 1;
        test1[1] = 2;
        test1[2] = 3;
        test1[3] = 4;

        int [] test2 = new int[5];
        test2[0] = 1;
        test2[1] = -100;
        test2[2] = -2;
        test2[3] = 10;
        test2[4] = 4;

        MaxProdOfThreeNum maxProdOfThreeNum = new MaxProdOfThreeNum();
        System.out.println(maxProdOfThreeNum.maximumProduct(test1));
        System.out.println(maxProdOfThreeNum.maximumProduct(test2));
    }
}
