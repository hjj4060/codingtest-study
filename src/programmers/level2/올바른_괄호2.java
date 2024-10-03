package programmers.level2;

import java.util.Stack;

public class 올바른_괄호2 {
	public static void main(String[] args) {
		String s = ")()(";
		System.out.println(solution(s));
	}

	static boolean solution(String s) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push('(');
			} else if (s.charAt(i) == ')') {
				if (stack.empty()) {
					return false;
				}

				stack.pop();
			}
		}
		if (stack.empty()) {
			return true;
		}

		return false;
	}
}
