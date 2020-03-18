package com.company.lcof;

import java.util.Stack;

public class LCOF31 {

    Stack<Integer> stack = new Stack<>();

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int index = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (stack.size()>0 && stack.peek() == popped[index]){
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

}
