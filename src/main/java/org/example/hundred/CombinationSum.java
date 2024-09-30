package org.example.hundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0, 0, new ArrayList<Integer>(), result, candidates, target);
        return result;
    }

    public void helper(int currentSum, int index, List<Integer> combination, List<List<Integer>> result, int[] candidates, int target) {
        if (currentSum > target) return;
        if (currentSum == target) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            int n = candidates[i];
            combination.add(n);
            helper(currentSum + n, i, combination, result, candidates, target);
            combination.remove(combination.size() - 1);
        }
    }
}
