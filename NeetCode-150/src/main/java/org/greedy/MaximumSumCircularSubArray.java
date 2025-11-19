package org.greedy;

public class MaximumSumCircularSubArray {
    public int maxSubarraySumCircular(int[] nums) {
        int curMax = 0;
        int curMin = 0;
        int maxSum = nums[0];
        int minSum =  nums[0];
        int totalSum = 0;

        for(int num: nums){
            curMax = Math.max(curMax,0) + num;
            maxSum = Math.max(curMax, maxSum);
            curMin = Math.min(curMin,0) + num;
            minSum = Math.min(curMin,minSum);
            totalSum += num;
        }
        if(totalSum == minSum){
            return maxSum;
        }

        return Math.max(maxSum, totalSum - minSum);
    }
}
