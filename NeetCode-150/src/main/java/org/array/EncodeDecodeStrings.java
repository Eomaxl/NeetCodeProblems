package org.array;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {

    public String encode(List<String> strs){
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str).append("|");
        }
        return sb.toString();
    }

    public List<String> decode(String str){
        String[] strArr = str.split("|");
        List<String> result = new ArrayList<>();
        for(String s: strArr){
            result.add(s);
        }
        return result;
    }
}
