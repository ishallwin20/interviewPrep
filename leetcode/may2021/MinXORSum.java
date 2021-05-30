package may2021;

import java.util.*;
import java.util.stream.IntStream;

public class MinXORSum {
    public int minimumXORSum(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);


        Map<Integer,Integer> countMap1 = new HashMap<>();
        Map<Integer,Integer> countMap2 = new HashMap<>();

        for(int i : nums1) {
            countMap1.put(i,countMap1.getOrDefault(i,0)+1);
        }
        for(int i : nums2) {
            countMap2.put(i,countMap2.getOrDefault(i,0)+1);
        }

        List<Integer> l1 = new ArrayList<Integer>(nums1.length);
        for (int i : nums1)
        {
            if(countMap1.get(i)-countMap2.getOrDefault(i,0) > 0) {
                l1.add(i);
                countMap1.put(i,countMap1.get(i)-1);
            }
        }

        List<Integer> l2 = new ArrayList<Integer>(nums2.length);
        for (int i : nums2)
        {
            if(countMap2.get(i)-countMap1.getOrDefault(i,0) > 0) {
                l2.add(i);
                countMap2.put(i,countMap2.get(i)-1);
            }
        }



        int xorSum = 0;

        for(int i=0;i<l1.size();i++) {
            xorSum = xorSum + (l1.get(i) ^ l2.get(i));
        }

        return xorSum;

    }


    public static void main(String[] args) {
        int[] test1 = new int[3];
        int[] test2 = new int[3];

        test1[0]=1;
        test1[1]=0;
        test1[2]=3;

        test2[0]=5;
        test2[1]=3;
        test2[2]=4;

        int[] test3 = new int[5];
        int[] test4 = new int[5];

        test3[0]=72;
        test3[1]=97;
        test3[2]=8;
        test3[3]=32;
        test3[4]=15;

        test4[0]=63;
        test4[1]=97;
        test4[2]=57;
        test4[3]=60;
        test4[4]=83;


        MinXORSum minXORSum = new MinXORSum();
        System.out.println(minXORSum.minimumXORSum(test3,test4));
    }
}
