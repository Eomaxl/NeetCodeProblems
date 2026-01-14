package string.medium;

public class LongestCommonPrefix {
    static void main(){
        IO.println(longestPrefix("abcabcbb"));
        IO.println(longestPrefix("bbbbbbb"));
    }

    public static int longestPrefix(String str){
        Integer[] arr = new Integer[128];
        int l =0, r = 0, res = 0;

        while (r < str.length()){
            char c = str.charAt(r);
            IO.print("Char at index "+r+" is : "+c);
            Integer index = arr[c];
            IO.print("|| Value of index is :"+index);

            if(index != null && index >= l && index < r){
                l = index + 1;
            }

            res = Math.max(res, r-l +1);
            IO.println("|| The value of res is : "+res);
            arr[c] = r;
            r++;
        }
        return res;
    }
}
