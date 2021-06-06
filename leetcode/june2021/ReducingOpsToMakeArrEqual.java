package june2021;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ReducingOpsToMakeArrEqual {
    public int reductionOperations(int[] nums) {
        Map<Integer,Integer> data = new TreeMap<Integer, Integer>();
        for(int num : nums) {
            data.put(num, data.getOrDefault(num,0)+1);
        }

        int count = 0;
        Object[] keyArr = data.keySet().toArray();
        int itr = data.size() - 1;
        while(data.keySet().size() > 1) {
            int currKey = (int) keyArr[itr];
            int prevKey = (int) keyArr[itr-1];
            int curr = data.get(currKey);
            count = count + curr;
            data.put(prevKey, data.get(prevKey) + curr);
            data.remove(currKey);
            itr--;
        }

        return count;
    }

    public static void main(String[] args) {
        ReducingOpsToMakeArrEqual reducingOpsToMakeArrEqual = new ReducingOpsToMakeArrEqual();

        System.out.println(reducingOpsToMakeArrEqual.reductionOperations(new int[] {7,9,10,8,6,4,1,5,2,3}));
    }
}
