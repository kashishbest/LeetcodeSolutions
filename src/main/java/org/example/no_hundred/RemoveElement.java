package org.example.no_hundred;

/**
 * https://leetcode.com/problems/remove-element/description/
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int l = 0;
        int r = 0;

        while(r < nums.length) {
            if(nums[r] != val) {
                nums[l++] = nums[r];
            }
            r++;
        }
        return l;
    }
}
