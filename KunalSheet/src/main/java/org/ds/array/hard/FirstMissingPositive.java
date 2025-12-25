package org.ds.array.hard;

/**
 * Given an unsorted integer array named nums. Return the smallest positive integer that is not present in nums.
 * You must implement an algorithm that runs in O(n) time and uses O(1) auxillary space.
 * 
 * Input : nums = [1, 2, 0] Output: 2, Explaination: the number in the range [1,2] are all in the array.
 * Input : nums = [3, 4, -1, 1] Output: 2, Explaination: 1 is in the array but 2 is missing.
 * 
*/

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] arr1 = {1,2,0};
        int[] arr2 = {3,4,-1,1};
        FirstMissingPositive obj = new FirstMissingPositive();
        System.out.println(obj.firstMissingNumber(arr1));
        System.out.println(obj.firstMissingNumber(arr2));
    }

    public int firstMissingNumber(int[] nums){
        int n = nums.length;
        boolean[] seen = new boolean[n+1];

        for(int num: nums){
            if(num >0 && num < n){
                seen[num] = true;
            }
        }

        for(int i =1; i<= n; i++){
            if(!seen[i]){
                return i;
            }
        }
        return n+1;
    }
}