package org.example.two_hundred;

import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/contains-duplicate-iii/description/
 */
public class ContainsDuplicateIII {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {

        NavigableSet<Integer> set = new TreeSet<>();

        for(int i = 0; i < nums.length; i++) {

            int minValue = nums[i]-valueDiff;
            int maxValue = nums[i]-valueDiff;

            Integer v1 = set.floor(maxValue);
            Integer v2 = set.ceiling(minValue);
            Integer diff1 = v1 == null ? null:Math.abs(v1-nums[i]);
            Integer diff2 = v2 == null ? null:Math.abs(v2-nums[i]);
            if((diff1 != null && diff1 <= valueDiff) || (diff2 != null && diff2 <= valueDiff))
                return true;
            set.add(nums[i]);
            int indexToRemove = i - indexDiff;
            if(indexToRemove >= 0)
                set.remove(nums[indexToRemove]);
        }
        return false;

    }
}
