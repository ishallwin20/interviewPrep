package may2021;

import java.util.Arrays;

public class MaxPointsFromDeckofCards {

    /*private int recursive(int[] cardPoints, int k, int i, int j) {
        if(k==1) return  Math.max(cardPoints[i],cardPoints[j]);

        return Math.max( cardPoints[i] + recursive(cardPoints,k-1,i+1,j) , cardPoints[j] + recursive(cardPoints, k-1, i, j-1)  );
    }

    public int maxScore(int[] cardPoints, int k) {
        return  recursive(cardPoints,k,0,cardPoints.length-1);
    }*/

    public int maxScore(int[] cardPoints, int k) {
        int contDeckLength = cardPoints.length - k;
        int sumOfArr = Arrays.stream(cardPoints).sum();

        if(contDeckLength == 0) return sumOfArr;
        int removeThis = 0;
        int sumBw = 0;
        int minSumOfContArray = Integer.MAX_VALUE;
        for(int i=0; i <= cardPoints.length - contDeckLength; i++) {
            if(i==0) {
                sumBw = sumBetweenTwoInd(cardPoints, i, contDeckLength + i - 1);
            }else {
                sumBw  = sumBw - removeThis + cardPoints[i+contDeckLength-1];
            }
            removeThis = cardPoints[i];
            if(sumBw < minSumOfContArray) minSumOfContArray = sumBw;
        }
        return sumOfArr - minSumOfContArray;
    }

    private int sumBetweenTwoInd(int [] cardPoints, int begin, int end) {
        int sum = 0;
        for(int i = begin;i<=end;i++) {
            sum += cardPoints[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] test1 = new int[7];
        test1[0] = 1;
        test1[1] = 2;
        test1[2] = 3;
        test1[3] = 4;
        test1[4] = 5;
        test1[5] = 6;
        test1[6] = 1;
        MaxPointsFromDeckofCards maxPointsFromDeckofCards = new MaxPointsFromDeckofCards();
        System.out.println(maxPointsFromDeckofCards.maxScore(test1,3));
    }
}
