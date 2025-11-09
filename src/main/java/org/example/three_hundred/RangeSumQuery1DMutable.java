package org.example.three_hundred;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RangeSumQuery1DMutable {
    int[] nums;
    public RangeSumQuery1DMutable(int[] nums) {
        this.nums = nums;
    }

    public void update(int index, int val) {
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return IntStream.range(left,right+1).map((i) ->nums[i]).sum();
    }
}
