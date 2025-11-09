package org.example.three_hundred;

import java.util.*;

public class RandomPickIndex {

    Map<Integer, List<Integer>> map;
    Random random;
    public RandomPickIndex(int[] nums) {
        random = new Random();
        map = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            int num = nums[i];
            List<Integer> li = map.getOrDefault(num,new ArrayList<>());
            li.add(i);
            map.put(num,li);
        }
    }

    public int pick(int target) {
        List<Integer> l = map.get(target);
        return l.get(random.nextInt(l.size()));
    }
}
