package org.greedy;

import java.util.Stack;

public class BuildingWithOceanView {
    public int[] findBuildings(int[] heights){
        int len = heights.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0 ; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
                stack.pop();
            }
            stack.push(i);
        }

        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i>= 0; i--){
            res[i] = stack.get(i);
        }

        return res;
    }
}
