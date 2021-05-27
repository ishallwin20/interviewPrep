package arrays;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int zeroPointer = -1;

        for(int i=0;i<nums.length;i++) {
            if(nums[i] == 0) {
                zeroPointer = i;
                break;
            }
        }

        if(zeroPointer != -1) {
            for(int i = zeroPointer+1;i<nums.length;i++) {
                if(nums[i] != 0) {
                    nums[zeroPointer] = nums[i];
                    nums[i] = 0;
                    zeroPointer ++;
                }
            }
        }

    }
    public static void main(String[] args) {
        int[] test1 = new int[1];
        test1[0] = 0;

        int[] test2 = new int[1];
        test2[0] = 1;

        int[] test3 = new int[3];
        test3[0] = 1;
        test3[1] = 1;
        test3[2] = 0;

        int[] test4 = new int[3];
        test4[0] = 0;
        test4[1] = 0;
        test4[2] = 1;


        MoveZeroes mz = new MoveZeroes();

        mz.moveZeroes(test1);
        mz.moveZeroes(test2);
        mz.moveZeroes(test3);
        mz.moveZeroes(test4);
    }
}
