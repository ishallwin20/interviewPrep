package string;

import java.util.*;

public class ReorganiseString {
    public String reorganizeString(String s) {
        Map<Character,Integer> charFreqMap = charToFreqMap(s);

        StringBuilder sb = new StringBuilder();
        boolean found = false;
        int counter = 0;
        List<Character> keyList = new ArrayList<Character>(charFreqMap.keySet());
        int zeroCount = 0;
        while(true) {

            if(charFreqMap.get(keyList.get(counter)) != 0) {
                sb.append(keyList.get(counter));
                int updatedVal = charFreqMap.get(keyList.get(counter))-1;
                zeroCount += (updatedVal <= 0 ? 1 : 0);
                charFreqMap.put(keyList.get(counter), updatedVal);
            } else {
                zeroCount++;
            }


            counter++;

            if(zeroCount == charFreqMap.size()) {
                found = true;
                break;
            }
            if(counter == charFreqMap.size()) {
                counter = 0;
                zeroCount = 0;
            }
        }

        return found ? sb.toString() : "";
    }

    private Map<Character,Integer> charToFreqMap(String s) {
        Map<Character, Integer> nmap = new HashMap<>();

        for(int i=0;i<s.length();i++) {
            nmap.put(s.charAt(i), nmap.getOrDefault(s.charAt(i),0)+1);
        }

        return nmap;
    }
    public static void main(String[] args) {
        ReorganiseString r = new ReorganiseString();
        System.out.println(r.reorganizeString("abacc"));
        System.out.println(r.reorganizeString("abaccc"));
    }
}
