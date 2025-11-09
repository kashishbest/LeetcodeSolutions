package org.example.three_hundred;

import java.util.stream.IntStream;

public class RangeSumQuery1D {
    int[] nums;
    public RangeSumQuery1D(int[] nums) {
        int sum = 0;
        for(int i = 0; i<nums.length; i++) {
            sum+=nums[i];
            nums[i]=sum;
        }
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        if(left == 0) return nums[right];
        return nums[right]-nums[left-1];
    }
}
