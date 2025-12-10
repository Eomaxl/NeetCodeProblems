package org.ds.array.easy;

public class MoveZeros {
    static void main(){
        int[] nums = {0,1,0,3,12};
        moveZero(nums);
    }

    static void moveZero(int[] nums){
        int p1= 0, p2 = 0;
        while(p2 < nums.length) {
            if((nums[p1] == 0) && (nums[p2] != 0)) {
                nums[p1] = nums[p2];
                nums[p2] = 0;
                p1++;
            }
            p2++;
        }
        for(int i: nums){
            IO.print(i+" | ");
        }
    }
}
