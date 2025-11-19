package org.greedy;

public class MinimizeMaximumOfArray {
    public int minimizeArrayValue(int[] nums){
        int result = 0;
        long prefix = 0L;

        for (int i = 0; i< nums.length; i++) {
            prefix += nums[i];

            int needed = (int)(prefix + i)/(i+1);
            result = Math.max(needed, result);
        }
        return result;
    }
}
