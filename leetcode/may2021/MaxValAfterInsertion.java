package may2021;

public class MaxValAfterInsertion {
    public String maxValue(String n, int x) {
        StringBuilder sb = new StringBuilder(n);
        if(sb.charAt(0) == '-') {
            //Negative Value
            boolean inserted = false;
            for(int i=1;i<sb.length();i++) {
                if(Character.getNumericValue(sb.charAt(i)) > x) {
                    sb.insert(i,x);
                    inserted = true;
                    break;
                }
            }
            if(!inserted) sb.append(x);
        } else{
            //Positive Value
            boolean inserted = false;
            for(int i=0;i<sb.length();i++) {
                if(Character.getNumericValue(sb.charAt(i)) < x) {
                    sb.insert(i,x);
                    inserted = true;
                    break;
                }
            }
            if(!inserted) sb.append(x);
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        MaxValAfterInsertion maxValAfterInsertion = new MaxValAfterInsertion();
        System.out.println(maxValAfterInsertion.maxValue("73",6));
        System.out.println(maxValAfterInsertion.maxValue("789439",5));
        System.out.println(maxValAfterInsertion.maxValue("789",5));
        System.out.println(maxValAfterInsertion.maxValue("789",9));

        System.out.println(maxValAfterInsertion.maxValue("-73",6));
        System.out.println(maxValAfterInsertion.maxValue("-789439",5));
        System.out.println(maxValAfterInsertion.maxValue("-789",5));
        System.out.println(maxValAfterInsertion.maxValue("-789",9));
    }
}
