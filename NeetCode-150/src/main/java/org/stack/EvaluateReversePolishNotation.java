package org.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> helperStack = new Stack<Integer>();
        for(String str: tokens) {
            if (str.equals("+")){
                helperStack.push(helperStack.pop() + helperStack.pop());
            } else  if (str.equals("-")){
                int num1 = helperStack.pop();
                int num2 = helperStack.pop();
                helperStack.push(num2 - num1);
            } else  if (str.equals("*")){
                helperStack.push(helperStack.pop() * helperStack.pop());
            } else  if (str.equals("/")){
                int num1 = helperStack.pop();
                int num2 = helperStack.pop();
                helperStack.push(num2 / num1);
            } else {
                helperStack.push(Integer.parseInt(str));
            }
        }
        return helperStack.peek();
    }
}
