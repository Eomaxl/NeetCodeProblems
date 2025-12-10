package org.ds.array.easy;

public class MergeSortedArray {
    static void main(){
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        int[] result = mergeArr(nums1,m,nums2,n);
        for(int i: result){
            IO.print(i+" , ");
        }
    }

    static int[] mergeArr(int[] arr1, int m, int[] arr2, int n){
        int p1 = 0, p2 = 0;
        int[] result = new int[m+n];
        int i =0;
        while (p1 <m && p2 <n){
            if (arr1[p1] < arr2[p2]){
               result[i] = arr1[p1];
               p1++;
            } else {
                result[i] = arr2[p2];
                p2++;
            }
            i++;
        }

        while (p2 < n){
            result[i] = arr2[p2];
            p2++;
            i++;
        }
        while (p1 < m){
            result[i] = arr1[p1];
            p1++;
            i++;
        }
        return result;
    }
}
