public class Solution2 implements Solution {
    @Override
    public void setZeroes(int[][] matrix) {
//        print(matrix);
        int nrow = matrix.length, ncol = matrix[0].length;
        boolean row0hasZero = false;
        for (int j = 0; j < ncol; j++) {
            if (matrix[0][j] == 0) {
                row0hasZero = true;
            }
            for (int i = 1; i < nrow; i++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
//        print(matrix);
//        System.out.println("row0hasZero = " + row0hasZero);
//        System.out.println();

//        for (int j = 0; j < ncol; j++) {
//            if (matrix[0][j] == 0) {
//                for (int i = 1; i < nrow; i++) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//        print(matrix);

//        for (int i = 1; i < nrow; i++) {
//            if (matrix[i][0] == 0) {
//                for (int j = 1; j < ncol; j++) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//        print(matrix);

        for (int j = 1; j < ncol; j++) {
            for (int i = 1; i < nrow; i++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int i = 1; i < nrow; i++) {
                matrix[i][0] = 0;
            }
        }

        if (row0hasZero) {
            for (int j = 0; j < ncol; j++) {
                matrix[0][j] = 0;
            }
//            print(matrix);
        }
    }

    private void print(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
