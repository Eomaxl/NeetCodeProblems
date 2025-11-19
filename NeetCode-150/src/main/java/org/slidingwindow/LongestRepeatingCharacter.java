package org.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacter {
    public int CharacterReplacement(String s, int k) {
        Map<Character, Integer> charMap = new HashMap<>();
        int l = 0, res = 0, maxF = 0;

        for (int r = 0; r < s.length(); r++){
            charMap.put(s.charAt(r), charMap.getOrDefault(s.charAt(r), 0) + 1);
            maxF = Math.max(maxF, charMap.get(s.charAt(r)));

            while ((r-l + 1) - maxF > k) {
                charMap.put(s.charAt(l), charMap.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
