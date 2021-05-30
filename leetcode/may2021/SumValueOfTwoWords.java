package may2021;

public class SumValueOfTwoWords {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return (sumOfWord(firstWord) + sumOfWord(secondWord) == sumOfWord(targetWord));
    }
    private int sumOfWord(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++) {
            sb.append((int) s.charAt(i) - 97);
        }

        return Integer.parseInt(sb.toString());
    }
    public static void main(String[] args) {
        SumValueOfTwoWords sumValueOfTwoWords = new SumValueOfTwoWords();
        /*System.out.println(sumValueOfTwoWords.sumOfWord("acb"));
        System.out.println(sumValueOfTwoWords.sumOfWord("cba"));
        System.out.println(sumValueOfTwoWords.sumOfWord("cdb"));
        System.out.println(sumValueOfTwoWords.sumOfWord("aaa"));*/

        System.out.println(sumValueOfTwoWords.isSumEqual("acb","cba","cdb"));
        System.out.println(sumValueOfTwoWords.isSumEqual("aaa","aaaaaaa","a"));
        System.out.println(sumValueOfTwoWords.isSumEqual("aaa","aaaabaa","a"));
    }
}
