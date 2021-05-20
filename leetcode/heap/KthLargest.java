package heap;

import com.sun.security.auth.module.Krb5LoginModule;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KthLargest {
    List<Integer> streamList;
    int k;

    public KthLargest(int k, int[] nums) {
        Arrays.sort(nums);
        this.streamList = Arrays.stream(nums)        // IntStream
                .boxed()          // Stream<Integer>
                .collect(Collectors.toList());
        this.k = k;
    }

    public int add(int val) {
        for(int i=0;i<streamList.size();i++) {
            if(val < streamList.get(i)) {
                streamList.add(i,val);
                break;
            }
        }
        return (int)streamList.get(k-1);
    }
}

class KthLargestDriver {
    public static void main(String[] args) {
        int [] test = new int[5];
        test[0] = 10;
        test[1] = 8;
        test[2] = 12;
        test[3] = 4;
        test[4] = 6;
        KthLargest kthLargest = new KthLargest(3,test);
        System.out.println(kthLargest.add(7));
    }
}