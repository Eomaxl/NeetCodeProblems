package org.greedy;

public class SeparateBlackAndWhiteBalls {
    public long minimumSteps(String s) {
        long totalSwaps = 0;
        int blackBallCount = 0;

        for (int i =0; i< s.length(); i++) {
            if (s.charAt(i) == '0') {
                totalSwaps += (long) blackBallCount;
            } else {
                blackBallCount++;
            }
        }
        return totalSwaps;
    }
}
