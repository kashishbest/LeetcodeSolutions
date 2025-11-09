package org.example.three_hundred;

/**
 * https://leetcode.com/problems/range-sum-query-2d-immutable/description/
 */
public class RangeSumQuery2D {
    int[][] matrix;
    public RangeSumQuery2D(int[][] matrix) {
        int[][] directions = new int[][] {{-1,-1},{-1,0},{0,-1}};
        int[] multiplier = new int[] {-1,1,1};
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int sum = matrix[i][j];
                for (int k =0; k < directions.length; k++) {
                    int[] direction = directions[k];
                    int r = i + direction[0];
                    int c = j + direction[1];
                    if(r < 0 || c < 0 || r == matrix.length || c == matrix[i].length) continue;
                    sum += multiplier[k] * matrix[r][c];
                }
                matrix[i][j] = sum;
            }
        }
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = matrix[row2][col2];
        if(row1 > 0) result -= matrix[row1-1][col2];
        if(col1 > 0) result -= matrix[row2][col1-1];
        if(row1 > 0 && col1 > 0) result += matrix[row1-1][col1-1];
        return result;
    }
}
