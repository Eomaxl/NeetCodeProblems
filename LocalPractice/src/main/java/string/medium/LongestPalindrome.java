package string.medium;

public class LongestPalindrome {
    static void main(){
        IO.println(longPalindrome("babad"));
    }

    public static String longPalindrome(String s){
        int[] ans = new int[]{0,0};

        for(int i =0; i< s.length(); i++){
            int oddLength = expand(i,i,s);
            if (oddLength > ans[1] - ans[0] + 1){
                int dist = oddLength / 2;
                ans[0] = i - dist;
                ans[1] = i + dist;
            }

            int evenLength = expand(i, i+1, s);
            if (evenLength > ans[1]- ans[0]+1){
                int dist = (evenLength/2) - 1;
                ans[0] = i- dist;
                ans[1] = i + 1 + dist;
            }
        }
        return s.substring(ans[0], ans[1]+1);
    }

    private static int expand(int l, int r, String s){
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }

        return r - l - 1;
    }
}
