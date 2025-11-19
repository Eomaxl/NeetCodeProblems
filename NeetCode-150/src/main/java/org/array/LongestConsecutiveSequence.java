package org.array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums){
        Set<Integer> numSet = new HashSet<>();
        for (int num: nums){
            numSet.add(num);
        }

        int longest = 0;

        for (int num: nums) {
            if(!numSet.contains(num - 1)) {
                int length = 1;
                while (numSet.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
