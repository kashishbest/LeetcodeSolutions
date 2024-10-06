package org.example.hundred;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> soln = new ArrayList<>();
        helper(new ArrayList<Integer>(), soln,nums);
        return soln;
    }

    private void helper(List<Integer> combination, List<List<Integer>> soln, int[] nums) {
        if(combination.size() == nums.length) {
            soln.add(new ArrayList<Integer>(combination));
            return;
        }
        for(int num : nums) {
            if(!combination.contains(num)) {
                combination.add(num);
                helper(combination,soln,nums);
                combination.remove(combination.size()-1);
            }
        }
    }
}
