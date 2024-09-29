package org.example.hundred;

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int idx = 1;
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i-1]==nums[i]) {
                count++;
                if(count <= 2) {
                    nums[idx] = nums[i];
                    idx++;
                }

            } else {

                nums[idx] = nums[i];
                idx++;
                count = 1;
            }
        }
        return idx;
    }
}
