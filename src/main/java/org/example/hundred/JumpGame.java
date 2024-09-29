package org.example.hundred;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/jump-game/description/
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        AtomicInteger maxIndex = new AtomicInteger(0);
        IntStream.range(0,nums.length).forEach(index -> {
            if(index <= maxIndex.get())
                maxIndex.set( Math.max(maxIndex.get(), index + nums[index]));
        });
        return maxIndex.get() >= nums.length-1;
    }
}
