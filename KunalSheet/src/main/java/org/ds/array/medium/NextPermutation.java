package org.ds.array.medium;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args){
        int[] nums = {1,2,3}; // o/p: [1,3,2]
        int[] num1 = {3,2,1}; // o/p: [1,2,3]
        nextPermutation(nums);
        nextPermutation(num1);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(num1));
    }

    public static void nextPermutation(int[] nums) {
         int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private  static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}

