package org.example.two_hundred;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {

        int[] soln = new int[nums.length];
        Arrays.fill(soln,1);
        int prefix = 1;

        for(int i = 0; i < nums.length; i++) {
            soln[i] = prefix;
            prefix *= nums[i];
        }
        prefix = 1;
        for(int i = nums.length-1; i>=0; i--) {
            soln[i] *= prefix;
            prefix *= nums[i];
        }
        return soln;
    }
}
