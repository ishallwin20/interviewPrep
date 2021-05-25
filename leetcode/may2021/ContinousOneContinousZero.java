package may2021;

public class ContinousOneContinousZero {
    public boolean checkZeroOnes(String s) {
        if(s.length()==1) return s.equals("1");

        int l0 = Integer.MIN_VALUE;
        int l1 = Integer.MIN_VALUE;

        int running0=0;
        int running1=0;
        char prev = s.charAt(0);
        if(prev=='0') running0=1;
        else running1=1;
        for(int i=1;i<s.length();i++) {
            if(s.charAt(i) == '0') {
                if(prev == '0') {
                    running0+=1;

                } else {
                    running0 = 1;
                    l1 = Math.max(running1,l1);
                    running1 = 0;
                }
            } else if(s.charAt(i) == '1') {
                if(prev == '1') {
                    running1+=1;

                } else {
                    running1 = 1;
                    l0 = Math.max(running0,l0);
                    running0 = 0;
                }
            }

            prev = s.charAt(i);

        }
        l1 = Math.max(l1,running1);
        l0 = Math.max(l0,running0);
        return l1>l0;
    }

    public static void main(String[] args) {
        ContinousOneContinousZero continousOneContinousZero = new ContinousOneContinousZero();
        System.out.println(continousOneContinousZero.checkZeroOnes("110100010")==false);
        System.out.println(continousOneContinousZero.checkZeroOnes("1")==true);
        System.out.println(continousOneContinousZero.checkZeroOnes("0")==false);
        System.out.println(continousOneContinousZero.checkZeroOnes("1101")==true);
        System.out.println(continousOneContinousZero.checkZeroOnes("111000")==false);

        System.out.println(continousOneContinousZero.checkZeroOnes("01100100110")==false);


    }
}
