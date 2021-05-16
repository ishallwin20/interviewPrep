package may2021;

public class MinSwapsToMakeBinAlternating {
    public int minSwaps(String s) {
        int count0 = 0;
        int count1 = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '0') count0++;
            else count1++;
        }


        if(s.length()%2 == 0) {
            if(count0 != s.length()/2 || count1 != s.length()/2) return -1;

            String withZeroBeginning = "";
            String withOneBeginning = "";


            for(int i=0;i<s.length();i++) {
                if(i%2 == 0) {
                    withOneBeginning += "1";
                    withZeroBeginning += "0";
                } else {
                    withOneBeginning += "0";
                    withZeroBeginning += "1";
                }
            }

            return  Math.min(disimilarities(withZeroBeginning,s),disimilarities(withOneBeginning,s))/2;

        } else {
            if(Math.abs(count0-count1) != 1) return -1;

            String alternatingString = "";
            if(count0 > count1) {
                for(int i=0;i<s.length();i++) {
                    if(i%2==0) alternatingString += "0";
                    else alternatingString += "1";
                }
            } else {
                for(int i=0;i<s.length();i++) {
                    if(i%2==0) alternatingString += "1";
                    else alternatingString += "0";
                }
            }

            return disimilarities(alternatingString,s)/2;
        }

    }

    private int disimilarities(String s1, String s2) {
        int count = 0;
        for(int i=0;i<s1.length();i++) {
            if(s1.charAt(i) != s2.charAt(i)) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        MinSwapsToMakeBinAlternating minSwapsToMakeBinAlternating = new MinSwapsToMakeBinAlternating();
        System.out.println(minSwapsToMakeBinAlternating.minSwaps("111000"));
        System.out.println(minSwapsToMakeBinAlternating.minSwaps("010"));
        System.out.println(minSwapsToMakeBinAlternating.minSwaps("1110"));
        System.out.println(minSwapsToMakeBinAlternating.minSwaps("11110"));
        System.out.println(minSwapsToMakeBinAlternating.minSwaps("11100"));
    }
}
