package may2021;

import java.util.List;

public class SortingSentence {
    public String sortSentence(String s) {
        String[] s_split = s.split(" ");
        String[] arranged = new String[s_split.length];

        for(int i=0;i<s_split.length;i++) {
            int pos = Character.getNumericValue(s_split[i].charAt(s_split[i].length() - 1));
            arranged[pos-1] = s_split[i].substring(0,s_split[i].length()-1);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arranged.length;i++) {
            sb.append(arranged[i] + " ");
        }

        return sb.toString().trim();
    }
    public static void main(String[] args) {
        SortingSentence sortingSentence = new SortingSentence();
        System.out.println(sortingSentence.sortSentence("is2 sentence4 This1 a3"));
        System.out.println(sortingSentence.sortSentence("Myself2 Me1 I4 and3"));
    }
}
