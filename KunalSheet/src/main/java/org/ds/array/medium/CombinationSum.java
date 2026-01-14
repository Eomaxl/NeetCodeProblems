package org.ds.array.medium;
import java.util.*;

public class CombinationSum {
    public static void main(String[] args){
        int[] candidates = {2,3,6,7};
        int target1 = 7;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> ans = new ArrayList<>();
        combinationSumUtil(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    private void combinationSumUtil(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds){
        if(ind == arr.length) {
            if (target == 0)
                ans.add(new ArrayList<>(ds));
            return;
        }

        if(arr[ind] <= target){
            ds.add(arr[ind]);
            combinationSumUtil(ind, arr, target - arr[ind], ans, ds);
            ds.remove(ds.size() - 1);
        }
        combinationSumUtil(ind+1, arr, target,ans, ds);
    }
}
