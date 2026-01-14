package org.ds.string.easy;

public class longestCommonPrefix {
    public static void main(String[] args){
        
    }

    public static String longestCommonPrefix(String[] strs){
        if (strs == null || strs.length == 0) return "";
        int minLen = Integer.MAX_VALUE;
        for(String str: strs) {
            minLen = Math.min(str.length(), minLen);
        }
        int low = 1;
        int high = minLen;
        while (low <= high){
            int middle= (low + high)/2;
            if(isCommonPrefix(strs,middle)){
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return strs[0].substring(0, (low+high)/2);
    }

    private static boolean isCommonPrefix(String[] strs, int middle){
        String str1 = strs[0].substring(0,middle);
        for (int i = 1; i< strs.length; i++){
            if(!strs[i].startsWith(str1)){
                return false;
            }
        }
        return true;
    }
}
