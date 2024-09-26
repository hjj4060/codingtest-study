package programmers.level2;

public class 전화번호_목록 {
	public static void main(String[] args) {
		String[] phoneBook = {"119", "97674223", "1195524421"};

		System.out.println(solution(phoneBook));
	}

	public static boolean solution(String[] phone_book) {
		boolean answer = true;

		loop:
		for (int i = 0; i < phone_book.length; i++) {
			String phone = phone_book[i];

			for (int j = 0; j < phone_book.length; j++) {
				if (i == j) {
					continue;
				}

				if (phone_book[j].startsWith(phone)) {
					answer = false;
					break loop;
				}
			}
		}

		return answer;
	}
}