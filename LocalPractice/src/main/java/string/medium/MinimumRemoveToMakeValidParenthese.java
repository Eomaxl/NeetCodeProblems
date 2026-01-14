package string.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class MinimumRemoveToMakeValidParenthese {
    static void main(){
        IO.println(minRemoveParenthese("lee(t(c)o)de)"));
        IO.println(minRemoveParenthese("a)b(c)d"));
        IO.println(minRemoveParenthese("))(("));
    }

    public static String minRemoveParenthese(String str){
        Set<Integer> indexesToRemove = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i =0; i< str.length(); i++) {
            if (str.charAt(i) == '('){
                stack.push(i);
            }
            if (str.charAt(i) == ')'){
                if (stack.isEmpty()){
                    indexesToRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        while(!stack.isEmpty()){
            indexesToRemove.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for(int i =0; i < str.length(); i++){
            if(!indexesToRemove.contains(i)){
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
