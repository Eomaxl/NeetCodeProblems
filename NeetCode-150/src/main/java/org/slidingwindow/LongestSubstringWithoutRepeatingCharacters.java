package org.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String str) {
        Set<Character> charSet = new HashSet<>();
        int start = 0;
        int max = 0;

        for(int end = 0; end < str.length(); end++){
            while (charSet.contains(str.charAt(end))){
                charSet.remove(str.charAt(start));
                start++;
            }
            charSet.add(str.charAt(end));
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}


// Time Complexity: O(n) n -> length of the string,
// Space Complexity: O(m), m -> total number of unique characters in the string