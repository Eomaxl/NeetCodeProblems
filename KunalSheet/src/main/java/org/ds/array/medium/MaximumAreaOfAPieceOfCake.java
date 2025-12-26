package org.ds.array.medium;

import java.util.*;

public class MaximumAreaOfAPieceOfCake {
    public static void main(String[] args){}

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts){
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int n = horizontalCuts.length;
        int m = verticalCuts.length;

        // Consider the edge first
        long maxHeight = Math.max(horizontalCuts[0], h - horizontalCuts[n-1]);
        for(int i= 1; i< n; i++){
            maxHeight = Math.max(maxHeight, horizontalCuts[i] - horizontalCuts[i-1]);
        }

        // Consider the edge first
        long maxWidth = Math.max(verticalCuts[0], w - verticalCuts[m-1]);
        for (int i = 1; i < m; i++) {
            maxWidth = Math.max(maxWidth, verticalCuts[i] - verticalCuts[i-1]);
        }

        return (int)(maxHeight * maxWidth)%(1000_000_007);
    }
}
