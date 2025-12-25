package org.ds.array.medium;
import java.util.*;

public class SubArraySumEqualsToK {
    public static int subarraySumCount(int[] arr, int k){
        int count = 0, sum =0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i =0; i< arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }

    public static void main(String[] args){
        int[] arr1 = {1,1,1};
        int target1 = 2;
        int[] arr2 = {1,2,3};
        int target2 = 3;
        System.out.println(subarraySumCount(arr2, target2));
        System.out.println(subarraySumCount(arr1, target1));
    }
}
