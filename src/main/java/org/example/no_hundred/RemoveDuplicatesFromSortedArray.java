package org.example.no_hundred;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int l = 0;
        int r = 0;
        int prev= -101;

        while(r < nums.length) {
            if(nums[r] != prev) {
                nums[l++] = nums[r];
                prev = nums[r];
            }
            r++;
        }
        return l;
    }
}
