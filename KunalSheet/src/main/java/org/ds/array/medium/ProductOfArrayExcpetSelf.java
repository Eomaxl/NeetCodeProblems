package org.ds.array.medium;

/**
 * 
 * i/p : [1,2,3,4]
 * o/p: [24, 12, 8, 6]
 *  {2,3,4},{1,3,4},{1,2,4},{1,2,3}
 *  {1},{1},{1,2},{1,2,3}
 * 
*/

public class ProductOfArrayExcpetSelf {
    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        int[] result = productOfSelf(nums);
        for(int i: result){
            System.out.print(i+" , ");
        }
    }

    public static  int[] productOfSelf(int[] arr){
        int[] result = new int[arr.length];
        int[] prefix = new int[arr.length];
        int[] suffix = new int[arr.length];
        prefix[0] = 1;
        for(int i = 1; i<arr.length; i++){
            prefix[i] = arr[i-1] * prefix[i-1];
        }

        suffix[arr.length] = 1;
        for (int i = arr.length-2; i>=0; i--){
            suffix[i] = arr[i+1] * suffix[i+1];
        }

        for(int i =0; i<arr.length; i++){
            result[i] = prefix[i] * suffix[i];
        }
        return result;
    }
    
}
