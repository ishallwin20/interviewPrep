package june2021;

public class AlternatingBinStrings {
    public int minFlips(String s) {
        int min = Integer.MAX_VALUE;
        StringBuilder s0 = new StringBuilder();
        StringBuilder s1 = new StringBuilder();
        StringBuilder modS = new StringBuilder();

        for(int i=0;i<s.length();i++) {
            if(i%2==0) {
                s0.append('0');
                s1.append('1');
            } else{
                s0.append('1');
                s1.append('0');
            }

            if(i!=0) modS.append(s.charAt(i));
        }

        modS.append(s.charAt(0));
        min = Math.min(min,differences(s,s0.toString()));
        min = Math.min(min,differences(s,s1.toString()));

        min = Math.min(min,differences(modS.toString(),s0.toString()));
        min = Math.min(min,differences(modS.toString(),s1.toString()));

        for(int i=0;i<s.length()-2;i++) {
            modS.append(modS.charAt(0));
            modS.deleteCharAt(0);

            min = Math.min(min,differences(modS.toString(),s0.toString()));
            min = Math.min(min,differences(modS.toString(),s1.toString()));
            if(min==0) break;
        }



        return min;
    }

    private int differences(String s1, String s2) {
        int count = 0;

        for(int i=0;i<s1.length();i++) {
            if(s1.charAt(i) != s2.charAt(i)) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        AlternatingBinStrings alternatingBinStrings = new AlternatingBinStrings();
        /*System.out.println(alternatingBinStrings.minFlips("111111"));
        System.out.println(alternatingBinStrings.minFlips("111000"));
        System.out.println(alternatingBinStrings.minFlips("11110"));
        System.out.println(alternatingBinStrings.minFlips("010"));
        System.out.println(alternatingBinStrings.minFlips("1110"));*/
        System.out.println(alternatingBinStrings.minFlips("01001001101"));
    }
}
