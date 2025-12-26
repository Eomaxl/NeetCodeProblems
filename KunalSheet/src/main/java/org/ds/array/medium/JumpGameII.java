package org.ds.array.medium;

public class JumpGameII {
    public int jump(int[] nums){
        int currEnd = 0, currFar = 0;
        int answer = 0, n = nums.length;

        for(int i =0; i< n; i++){
            currFar = Math.max(currFar, i+nums[i]);
            if (i == currEnd) {
                answer++;
                currEnd = currFar;
            }
        }
        return answer;
    }
}
