package may2021;

public class RotatingTheBox {
    public char[][] rotateTheBox(char[][] box) {
        char[][] fin = new char[box[0].length][box.length];

        for(int i = 0; i< box.length; i++) {
            int nextFall = box[0].length - 1;
            for(int j=box[0].length-1;j>=0;j--) {
                if(box[i][j] == '#') {
                    fin[nextFall][box.length-1-i] = '#';
                    nextFall --;
                } else if(box[i][j] == '*') {
                    nextFall = j-1;
                    fin[j][box.length-1-i] = '*';
                }
            }
        }

        for(int i=0;i<fin.length;i++) {
            for(int j=0;j<fin[0].length;j++) {
                if(fin[i][j] != '*' && fin[i][j] != '#') fin[i][j] = '.';
            }
        }

        return fin;
    }
    public static void main(String[] args) {
        char[][] test = new char[3][6];
        test[0][0] = '#';
        test[0][1] = '#';
        test[0][2] = '*';
        test[0][3] = '.';
        test[0][4] = '*';
        test[0][5] = '.';


        test[1][0] = '#';
        test[1][1] = '#';
        test[1][2] = '#';
        test[1][3] = '*';
        test[1][4] = '.';
        test[1][5] = '.';


        test[2][0] = '#';
        test[2][1] = '#';
        test[2][2] = '#';
        test[2][3] = '.';
        test[2][4] = '#';
        test[2][5] = '.';

        RotatingTheBox rotatingTheBox = new RotatingTheBox();
        rotatingTheBox.rotateTheBox(test);

    }
}
