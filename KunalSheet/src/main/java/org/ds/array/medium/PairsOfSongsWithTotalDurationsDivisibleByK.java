package org.ds.array.medium;

public class PairsOfSongsWithTotalDurationsDivisibleByK {
    public int numPairsDivisibleBy60(int[] nums){
        int[] remainder = new int[60];
        int count = 0;
        for(int t: nums){
            if(t % 60 == 0) {
                count = count + remainder[0];
            } else {
                count = count + remainder[60 - t % 60]; 
            }
            remainder[t % 60]++;
        }
        return count;
    }
}
