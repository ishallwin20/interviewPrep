package may2021;

public class FindSumPairsDriver {
    public static void main(String[] args) {
        int [] nums1 = new int[6];
        nums1[0] = 1;
        nums1[1] = 1;
        nums1[2] = 2;
        nums1[3] = 2;
        nums1[4] = 2;
        nums1[5] = 3;

        int [] nums2 = new int[6];
        nums2[0] = 1;
        nums2[1] = 4;
        nums2[2] = 5;
        nums2[3] = 2;
        nums2[4] = 5;
        nums2[5] = 4;

        int[] test2_1 = new int[1];
        test2_1[0] = 1;

        int[] test2_2 = new int[1];
        test2_2[0] = 10;



        //FindSumPairs findSumPairs = new FindSumPairs(nums1, nums2);
        //findSumPairs.add(0,10);
        //System.out.println(findSumPairs.count(7));

        FindSumPairs findSumPairs1 = new FindSumPairs(test2_1,test2_2);
        System.out.println(findSumPairs1.count(100));
        System.out.println(findSumPairs1.count(11));
        findSumPairs1.add(0,89);
        System.out.println(findSumPairs1.count(100));
    }
}
