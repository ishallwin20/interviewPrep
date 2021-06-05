package june2021;

import java.util.ArrayDeque;
import java.util.Queue;

public class InterleavingStrings {
    public boolean isInterleave(String s1, String s2, String s3) {

        if(s1.length() == 0 && s2.length() == 0) {
            return s3.length() == 0;
        }

        if(s1.length() == 0) {
            return s3.equals(s2);
        }

        if(s2.length() == 0) {
            return s3.equals(s1);
        }

        if(s3.length() != s1.length() + s2.length()) return false;

        Queue<Character> qs1 = new ArrayDeque<Character>();
        Queue<Character> qs2 = new ArrayDeque<Character>();
        Queue<Character> qs3 = new ArrayDeque<Character>();

        for(int i=0;i< s1.length();i++) {
            qs1.add(s1.charAt(i));
        }

        for(int i=0;i< s2.length();i++) {
            qs2.add(s2.charAt(i));
        }

        for(int i=0;i< s3.length();i++) {
            qs3.add(s3.charAt(i));
        }

        for(int i=0;i<qs3.size();i++) {
            char currentChar = qs3.poll();
            if(currentChar != qs1.peek() || currentChar != qs2.peek()) {
                return false;
            }

        }

        return true;
    }
    public static void main(String[] args) {
        InterleavingStrings interleavingStrings = new InterleavingStrings();

        interleavingStrings.isInterleave("aabcc","dbbca","aadbbcbcac");
    }
}
