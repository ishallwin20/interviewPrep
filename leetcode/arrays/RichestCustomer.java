package arrays;

import java.util.Arrays;

public class RichestCustomer {
    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for(int [] eachAccount : accounts) {
            max = Math.max(max, Arrays.stream(eachAccount).sum());
        }
        return max;
    }
    public static void main(String[] args) {
        RichestCustomer richestCustomer = new RichestCustomer();

        int [][] test = new int[][] {{2,8,7},{7,1,3},{1,9,5}};

        System.out.println(richestCustomer.maximumWealth(test));


    }
}
