package org.ds.string.easy;

public class addStrings {
    public static void main(String[] args){
        String str1 = "11";
        String str2 = "123";
        System.out.println(addStr(str1, str2));

    }

    public static String addStr(String str1, String str2){
        int num1 = Integer.parseInt(str1);
        int num2 = Integer.parseInt(str2);
        int result = num1 + num2;
        return Integer.toString(result);
    }
    
}
