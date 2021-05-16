package may2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

class FindSumPairs {
    int [] nums1;
    int [] nums2;

    Map<Integer, List<Integer>> nums2ToMap;
    Map<Integer,Integer> countMap;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;

        nums2ToMap = new HashMap<>();
        countMap = new HashMap<>();
        //Populating all sums in the map
        for(int i=0;i<nums2.length;i++) {
            List<Integer> countList = new ArrayList<>();
            nums2ToMap.put(i,countList);
            for(int j=0;j<nums1.length;j++) {
                nums2ToMap.get(i).add(nums2[i] + nums1[j]);
                countMap.put(nums2[i] + nums1[j],countMap.getOrDefault(nums2[i] + nums1[j],0)+1);
            }
        }
    }

    public void add(int index, int val) {
        nums2[index] += val;
        //Repopulating the map
        List<Integer> vals = nums2ToMap.get(index);
        for(int i=0;i<vals.size();i++) {

            countMap.put(vals.get(i),countMap.get(vals.get(i))-1);
            countMap.put(vals.get(i) + val, countMap.getOrDefault(vals.get(i) + val,0)+1);
            vals.set(i,vals.get(i) + val);
        }
    }


    public int count(int tot) {
        //Count all the tot in values of the above map
        return countMap.getOrDefault(tot,0);
    }
}

