package org.stack;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            int t = temperatures[i];
            while (!stack.isEmpty() && t > stack.peek()[0]){
                int[] pair  = stack.pop();
                res[pair[1]] = i - pair[1];
            }
            stack.push(new int[]{t, i});
        }
        return res;
    }
}
