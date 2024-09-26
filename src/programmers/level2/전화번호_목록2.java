package programmers.level2;

import java.util.HashMap;

public class 전화번호_목록2 {
	public static void main(String[] args) {
		String[] phoneBook = {"119", "97674223", "1195524421"};

		System.out.println(solution(phoneBook));
	}

	/**
	 * 핸드폰 번호 모두 map에 담는다.
	 * 핸드폰 번호 for문을 돌아서 map의 containsKey() 함수로 해시에 있는지 확인
	 */
	public static boolean solution(String[] phone_book) {
		boolean answer = true;

		HashMap<String, Integer> phoneMap = new HashMap<>();

		for (int i = 0; i < phone_book.length; i++) {
			phoneMap.put(phone_book[i], i);
		}

		for (int i = 0; i < phone_book.length; i++) {
			for (int j = 0; j < phone_book[i].length(); j++) {
				if (phoneMap.containsKey(phone_book[i].substring(0, j))) {
					answer = false;
				}
			}
		}

		return answer;
	}
}