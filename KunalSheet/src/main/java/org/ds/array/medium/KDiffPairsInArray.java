package org.ds.array.medium;
import java.util.*;

public class KDiffPairsInArray {
    public static void main(String[] args){}

    public int findPairs(int[] nums, int k){
        int result = 0;
        Map<Integer,Integer> records = new HashMap<>();
        for(int n: nums){
            records.put(n, records.getOrDefault(n,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry: records.entrySet()){
            if(k > 0 && records.containsKey(entry.getKey() + k)){
                result++;
            } else if (k == 0 && entry.getValue() > 1){
                result++;
            }
        }
        return result;
    }
}
