package slidingwindow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinWindowSubStr {
    public String minWindow(String s, String t) {
        if(t.length() == 1) {
            if(s.contains(t)) return t;
            else return "";
        }

        Map<Character,Integer> runningCount = new HashMap<>();
        populateMap(runningCount,t);

        for(int i=0,j=0; j<s.length();) {
            String temp = s.substring(i,j+1);

        }
        return "";
    }

    private boolean checkIfMatched(Map<Character,Integer> runningCount) {
       if(runningCount.values().stream().noneMatch(e -> e ==0)) {
           return false;
       }
        return true;
    }

    private void populateMap(Map<Character,Integer> runningCount, String t) {
        for(int i=0;i<t.length();i++) {
            runningCount.put(t.charAt(i),runningCount.getOrDefault(t.charAt(i),0)+1);
        }
    }


    public static void main(String[] args) {
        MinWindowSubStr minWindowSubStr = new MinWindowSubStr();

        minWindowSubStr.minWindow("ADOBECODEBANC", "ABC");

        /*
        0-A
        3-B
        5-C
        9-B
        10-A
        12-C

        AAABBBCCC
         */
    }
}
