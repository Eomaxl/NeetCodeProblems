package org.greedy;

public class MinimumLengthOfStringAfterOperations {
    public int minimumLength(String s){
        int[] freq = new int[26];
        int totalCount = 0;

        for(char ch: s.toCharArray()){
            freq[ch - 'a']++;
        }

        for(int fr: freq){
            if ( fr % 2 == 0){
                totalCount += 2;
            } else {
                totalCount += 1;
            }
        }
        return totalCount;
    }
}
