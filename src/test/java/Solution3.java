public class Solution3 implements Solution {
    @Override
    public void setZeroes(int[][] matrix) {
        int nrow = matrix.length, ncol = nrow > 0 ? matrix[0].length : 0;
        boolean col0hasZero = false;

        for (int i = 0; i < nrow; i++) {
            if (matrix[i][0] == 0) {
                col0hasZero = true;
            }
            for (int j = 1; j < ncol; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = nrow-1; i >= 0; i--) {
            for (int j = 1; j < ncol; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0hasZero) {
                matrix[i][0] = 0;
            }
        }

//        if (matrix[0][0] == 0) {
//            for (int j = 1; j < ncol; j++) {
//                matrix[0][j] = 0;
//            }
//        }
//
//        if (col0hasZero) {
//            for (int i = 1; i < nrow; i++) {
//                matrix[i][0] = 0;
//            }
//        }
    }
}
