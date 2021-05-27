package string;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        int buff = Math.max(0,numRows-2);

        for(int i=0;i<numRows;i++) {
            for(int j=0;i+numRows*j + buff*j < s.length();j++) {



                //System.out.println(s.charAt(i+numRows*j + buff*j));
                sb.append(s.charAt(i+numRows*j + buff*j));

                if((numRows+buff)*(j+1) - i < s.length() && (i>0 && i<numRows-1) && (j<(s.length()/numRows))) {
                    //System.out.println("-- "+s.charAt((numRows+buff)*(j+1) - i));
                    sb.append(s.charAt((numRows+buff)*(j+1) - i));
                }
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        System.out.println(zigZagConversion.convert("PAYPALISHIRING",4));
        System.out.println(zigZagConversion.convert("PAYPALISHIRING",3));
        System.out.println(zigZagConversion.convert("PAYPALISHIRING",2));
        System.out.println(zigZagConversion.convert("PAYPALISHIRING",1));
    }
}
