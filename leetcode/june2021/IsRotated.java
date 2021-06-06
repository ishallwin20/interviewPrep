package june2021;

public class IsRotated {
    public boolean findRotation(int[][] mat, int[][] target) {
        if(isMatrixEqual(mat,target)) return true;
        rotateMatrix(mat);
        if(isMatrixEqual(mat,target)) return true;
        rotateMatrix(mat);
        if(isMatrixEqual(mat,target)) return true;
        rotateMatrix(mat);
        if(isMatrixEqual(mat,target)) return true;

        return false;
    }

    private void rotateMatrix(int mat[][]) {
        int N = mat.length;
        for (int x = 0; x < N / 2; x++) {
            for (int y = x; y < N - x - 1; y++) {
                int temp = mat[x][y];
                mat[x][y] = mat[y][N - 1 - x];
                mat[y][N - 1 - x] = mat[N - 1 - x][N - 1 - y];
                mat[N - 1 - x][N - 1 - y] = mat[N - 1 - y][x];
                mat[N - 1 - y][x] = temp;
            }
        }
    }

    private boolean isMatrixEqual(int[][] mat1, int[][] mat2) {
        for(int i=0;i<mat1.length;i++) {
            for(int j =0;j<mat1.length;j++) {
                if(mat1[i][j] != mat2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsRotated isRotated = new IsRotated();
        System.out.println(isRotated.findRotation(new int[][] {{0,0,0},{0,1,0},{1,1,1}}, new int[][] {{1,1,1},{0,1,0},{0,0,0}}));
        System.out.println(isRotated.findRotation(new int[][] {{0,0,0},{0,1,0},{1,1,1}}, new int[][] {{1,0,0},{1,1,0},{1,0,0}}));
        System.out.println(isRotated.findRotation(new int[][] {{0,0,0},{0,1,0},{1,1,1}}, new int[][] {{1,1,1},{0,1,0},{0,0,1}}));
    }
}
