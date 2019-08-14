public class Solution1 implements Solution {
    @Override
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = m > 0 ? matrix[0].length : 0;
        int min = Math.min(m, n);

        int cycle = 0;
//        for (int i = 0; i < min; i++) {
//            if (matrix[i][i] == 0) {
//                int k = i+1;
//                while (k < min) {
//                    matrix[i][k] = 0;
//                    matrix[k][i] = 0;
//                    k++;
//                }
//            }
//        }
//        cycle++;
        print(matrix);

        if (m > n) {
            // num of rows > num of cols
            while (cycle*min <= n) {
                for (int i = 0; i < min && i + cycle * min < m; i++) {
                    for (int j = i+1; j < n; j++) {
                        if (matrix[i+cycle*min][j] == 0) {
                            int k = 0;
                            while (k < min && k+i+cycle*min < m) {
                                if (k != j) {
                                    matrix[k+cycle*min][j] = 0;
                                }
                                k++;
                            }
                        }
                    }

                    if (matrix[i + cycle * min][i] == 0) {
                        int k = 1;
                        while (k+i+cycle*min < m && k+i+cycle*min < (cycle+1)*min) {
                            matrix[i+k+cycle*min][i] = 0;
                            k++;
                        }
                        k = 1;
                        while (k+i < n) {
                            matrix[i + cycle * min][k] = 0;
                            k++;
                        }
                    }
                }
                cycle++;
                print(matrix);
            }
        } else {
            // num of rows < num of cols
            while (cycle*min <= m) {
                for (int i = 0; i < min && i+cycle*min < n; i++) {
                    if (matrix[i][i+cycle*min] == 0) {
                        int k = 1;
                        while (i+cycle*min+k < (cycle+1)*min && i+cycle*min+k < n) {
                            matrix[i][k+i+cycle*min] = 0;
                            k++;
                        }

                        k = 1;
                        while (i+k < m) {
                            matrix[i+k][i+cycle*min] = 0;
                            k++;
                        }
                    }
                }
                cycle++;
                print(matrix);
            }
        }

        for (int i = 0; i < m; i++) {
            if (rowContainsZero(matrix, i)) {
                System.out.println("row " + i + " has zero");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            if (colContainsZero(matrix, j)) {
                System.out.println("col " + j + " has zero");
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        print(matrix);
    }

    private boolean rowContainsZero(int[][] mat, int row) {
        int m = mat.length, n = m > 0 ? mat[0].length : 0;
        int min = Math.min(m, n);
        int q = row/min;
        for (int j = 0; j < n; j++) {
            if (mat[row][j] == 0) {
                int k = 1;
                while (k < (q+1)*min && k < n) {
                    if (mat[row][k] != 0) {
                        break;
                    }
                    k++;
                }
                if (k == (q+1)*min || k == n) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean colContainsZero(int[][] mat, int col) {
        int m = mat.length, n = m > 0 ? mat[0].length : 0;
        int min = Math.min(m, n);
        int q = col/min;
        for (int j = 0; j < m; j++) {
            if (mat[j][col] == 0) {
                int k = 1;
                while (k < (q+1)*min && k < m) {
                    if (mat[k][col] != 0) {
                        break;
                    }
                    k++;
                }
                if (k == (q+1)*min || k == m) {
                    return true;
                }
            }
        }
        return false;
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
