package structure;

import java.util.Stack;

public class StackStudy {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1); // 1 넣음
        stack.push(2); // 2 넣음
        stack.push(3); // 3 넣음

        stack.pop(); // 3반환
    }
}
