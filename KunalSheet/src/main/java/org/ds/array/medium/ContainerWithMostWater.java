package org.ds.array.medium;

public class ContainerWithMostWater {
    public static void main(String[] args){
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(findMaxArea(height));
    }
    public static int findMaxArea(int[] height){
        int maxArea = 0;
        int l=0, r = height.length -1;
        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r])*(r-l));
            if (height[l] < height[r]){
                l += 1;
            } else {
                r -= 1;
            }
        }
        return maxArea;
    }
}
