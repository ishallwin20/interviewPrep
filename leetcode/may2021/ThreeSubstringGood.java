package may2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSubstringGood {
    public int countGoodSubstrings(String s) {
        int count =0;

        for(int i=0;i<s.length()-2;i++) {
            String temp = "";
            for(int j=0;j<3;j++) {
                temp += s.charAt(i+j);
            }
            if(isGoodString(temp)) count++;
        }

        return count;
    }

    private boolean isGoodString(String s) {
        return (s.charAt(0) != s.charAt(1) && s.charAt(0) != s.charAt(2) && s.charAt(1) != s.charAt(2));
    }
    public static void main(String[] args) {
        ThreeSubstringGood threeSubstringGood = new ThreeSubstringGood();
        System.out.println(threeSubstringGood.countGoodSubstrings("aababcabc"));
    }
}
