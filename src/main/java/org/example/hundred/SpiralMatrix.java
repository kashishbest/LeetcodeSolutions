package org.example.hundred;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length==0 || matrix[0].length == 0) return Collections.EMPTY_LIST;
        int top = 0;
        int left = 0;
        int right = matrix[0].length-1;
        int bottom = matrix.length-1;
        /*
        t 2
        l 1
        r 1
        b 1
        */
        List<Integer> result = new ArrayList<Integer>();
        while(result.size() != matrix.length * matrix[0].length) {
            for(int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            for(int i = top; i<=bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            if(top-1 != bottom) {
                for(int i = right; i >=left; i--) {
                    result.add(matrix[bottom][i]);
                }
            }
            bottom--;
            if(left != right+1) {
                for(int i = bottom; i>=top; i--) {
                    result.add(matrix[i][left]);
                }
            }
            left++;
        }
        return result;
    }
}
