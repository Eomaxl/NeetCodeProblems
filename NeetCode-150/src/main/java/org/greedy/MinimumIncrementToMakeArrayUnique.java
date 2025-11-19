package org.greedy;

public class MinimumIncrementToMakeArrayUnique {
    public int minIncrementForUnique(int[] nums) {
        int n = nums.length;
        int max = 0;
        int minIncrements = 0;

        for (int val : nums) {
            max = Math.max(max, val);
        }

        int[] freq = new int[n + max];

        for (int val : nums){
            freq[val]++;
        }

        for (int i = 0 ; i < freq.length; i++) {
            if (freq[i] <= 1) continue;

            int duplicates= freq[i] - 1;
            freq[i + 1] += duplicates;
            freq[i] = 1;
            minIncrements += duplicates;
        }
        return minIncrements;
    }
}
