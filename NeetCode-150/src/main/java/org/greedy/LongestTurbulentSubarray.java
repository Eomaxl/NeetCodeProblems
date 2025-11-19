package org.greedy;

public class LongestTurbulentSubarray {
    public int maxTurbulenceSize1(int[] arr) {
        int N = arr.length;
        int ans = 1;
        int anchor  = 0;

        for (int i = 1; i < N; i++) {
            int c = Integer.compare(arr[i-1], arr[i]);
            if (c == 0) {
                anchor = i;
            } else if(i == N - 1 || c * Integer.compare(arr[i], arr[i+1]) != -1) {
                ans = Math.max(ans, i -anchor + 1);
                anchor = i;
            }
        }

        return ans;
    }

    public int maxTurbulenceSize2(int[] arr) {
        int l = 0, r = 1, res = 1;
        String prev = "";

        while (r < arr.length) {
            if (arr[r - 1] > arr[r] && !">".equals(prev)) {
                res = Math.max(res, r - l + 1);
                r++;
                prev = ">";
            } else if ( arr[r-1] < arr[r] && !"<".equals(prev)){
                res = Math.max(res, r - l + 1);
                r++;
                prev = "<";
            } else {
                r = (arr[r] == arr[r-1]) ? r + 1:r;
                l = r - 1;
                prev = "";
            }
        }
        return res;
    }
}
