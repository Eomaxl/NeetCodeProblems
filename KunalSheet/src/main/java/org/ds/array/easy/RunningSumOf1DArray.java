package org.ds.array.easy;

public class RunningSumOf1DArray {
    static void main(){
        int[] nums = new int[]{1,2,3,4};
        int[] output = runningSum(nums);
        for(int i : output){
            IO.print(i+ " , ");
        }
    }

    static int[] runningSum(int[] arr){
        int[] result = new int[arr.length];
        result[0] = arr[0];
        for(int i =1; i < arr.length; i++){
            result[i] = result[i-1] + arr[i];
        }
        return result;
    }
}
