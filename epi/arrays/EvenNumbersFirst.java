package arrays;

public class EvenNumbersFirst {

    private static int[] evenNoFirst(int [] nums) {

        int evenNumberPointer = 0;

        for(int i=0;i<nums.length;i++) {
            if(nums[i]%2 ==0 && evenNumberPointer != i) {
                int temp = nums[i];
                nums[i] = nums[evenNumberPointer];
                nums[evenNumberPointer] = temp;
                evenNumberPointer++;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] test = new int[5];

        test[0] = 1;
        test[1] = 3;
        test[2] = 5;
        test[3] = 6;
        test[4] = 8;

        int [] test2 = new int[1];
        test2[0] = 1;

        int [] test3 = new int[1];
        test3[0] = 4;

        int [] test4 = new int[3];
        test4[0] = 1;
        test4[1] = 3;
        test4[2] = 5;

        int [] test5 = new int[3];
        test5[0] = 2;
        test5[1] = 4;
        test5[2] = 6;



        evenNoFirst(test);
        evenNoFirst(test2);
        evenNoFirst(test3);
        evenNoFirst(test4);
        evenNoFirst(test5);
    }
}
