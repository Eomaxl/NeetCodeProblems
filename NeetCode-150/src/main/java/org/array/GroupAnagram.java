package org.array;

import java.util.*;

public class GroupAnagram {
    public List<List<String>>  groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            int[] res = new int[26];
            for(char c: s.toCharArray()) {
                res[c-'a']++;
            }
            String key = Arrays.toString(res);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}


// Time Complexity: O(m * n) --> m is the number of string, n is the length of the longest string
// Space Complexity : O(m) extra space, O(m * n)  space for the output list


