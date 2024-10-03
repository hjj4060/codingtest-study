package programmers.level2;

public class 올바른_괄호 {
	public static void main(String[] args) {
		String s = "()()";
		System.out.println(solution(s));
	}

	static boolean solution(String s) {
		int openCount = 0;
		int closeCount = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				openCount++;
			} else if (s.charAt(i) == ')') {
				closeCount++;
			}

			if (closeCount > openCount) {
				return false;
			}
		}

		if (openCount == closeCount) {
			return true;
		}

		return false;
	}
}
