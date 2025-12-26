package org.ds.array.medium;
/**
 * nums = [4,5,0,-2,-3,1] , k = 5
 * 
 * 
*/
public class SubarraySumsDivisibleByK {
    public static void main(String[] args){
        int[] nums = {4,5,0,-2,-3,1};
        int k = 5;
        SubArraySumEqualsToK obj = new SubArraySumEqualsToK();
        System.out.println(obj.subarraySumCount(nums, k));
    }
    public int subarraysDivByK(int[] nums, int k){
        int n = nums.length;
        int prefixMod = 0, result = 0;

        int[] modGroups = new int[k];
        modGroups[0] = 1;

        for(int num: nums){
            prefixMod = (prefixMod + num %k + k) % k;
            result += modGroups[prefixMod];
            modGroups[prefixMod]++;
        }
        return result;
    }
}
