package baekjoon.classfication.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1759
public class 암호만들기_1759 {
	static int passwordLength, charCnt;
	static char[] chars;
	static boolean[] selectChars;
	static List<Character> vowelList = Arrays.asList('a', 'e', 'i', 'o', 'u');

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		passwordLength = Integer.parseInt(st.nextToken());
		charCnt = Integer.parseInt(st.nextToken());

		chars = new char[charCnt];
		selectChars = new boolean[charCnt];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < charCnt; i++) {
			chars[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(chars);
	}

	public static void main(String[] args) throws IOException {
		input();

		solve();
	}

	private static void solve() {
		recur(0, 0);
	}

	private static void recur(int depth, int idx) {
		if (depth == passwordLength) {
			boolean existVowel = false;
			int consonantCnt = 0;

			for (int i = 0; i < charCnt; i++) {
				if (selectChars[i]) {
					if (vowelList.contains(chars[i])) {
						existVowel = true;
					} else {
						consonantCnt++;
					}
				}
			}
			if (!existVowel || !(consonantCnt >= 2)) {
				return;
			}

			for (int i = 0; i < charCnt; i++) {
				if (selectChars[i]) {
					System.out.print(chars[i]);
				}
			}

			System.out.println();
			return;
		}

		for (int i = idx; i < charCnt; i++) {
			if (!selectChars[i]) {
				selectChars[i] = true;
				recur(depth + 1, i + 1);
				selectChars[i] = false;
			}
		}
	}
}