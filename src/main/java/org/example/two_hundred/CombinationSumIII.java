package org.example.two_hundred;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iii/description/
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(k,n,1, new ArrayList<>(),0,result);
        return result;
    }

    private void helper(int k, int n, int i, List<Integer> current,int sum, List<List<Integer>> result) {
        if(current.size() == k) {
            if(sum == n) {
                result.add(new ArrayList<>(current));
            }
            return;
        }
        if(sum > n || i == 10) return;

        helper(k,n,i+1,current,sum,result);
        current.add(i);
        helper(k,n,i+1,current,sum+i,result);
        current.remove(current.size()-1);
    }
}
