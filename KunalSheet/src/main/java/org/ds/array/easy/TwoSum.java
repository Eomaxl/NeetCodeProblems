package org.ds.array.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args){
        int[] arr = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(arr, target);
        IO.println(result[0]+" "+result[1]);
    }

    public  static int[] twoSum(int[] arr, int target){
        int l =0, r = arr.length - 1;
        while (l < r) {
            int sum = arr[l] + arr[r];
            if(sum == target){
                return new int[]{l,r};
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[]{-1,-1};
    }

    public static int[] twoSumOnePass(int[] arr, int target){
        Map<Integer,Integer> mapping = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(mapping.containsKey(target-i)){
                return new int[]{i, mapping.get(target-i)};
            }
            mapping.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }
}
