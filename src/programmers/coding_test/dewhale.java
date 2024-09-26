package programmers.coding_test;

public class dewhale {
	public static void main(String[] args) {
		final String[] playerNames = {"영수", "광수", "영철", "상철"};

		Solution solution = new Solution();
		System.out.println(solution.solution(playerNames, 100));
	}
}

class Solution {
	/**
	 do369 함수를 이용하여 playNames의 유저가 돌아가면서,
	 maxGameCount까지 진행하도록 구현
	 각 유저는 본인의 차례때 '이름: 답변'을 출력한다.
	 예) playerNames = {"영수", "광수", "영철", "상철"} maxGameCount = 100 이 입력된경우
	 영수: 1
	 광수: 2
	 영철: clap
	 상철: 4
	 ..중략..
	 상철: 100
	 */
	public String solution(String[] playerNames, int maxGameCount) {
		StringBuilder answer = new StringBuilder();

		for (int i = 1; i <= maxGameCount; i++) {
			answer.append(playerNames[(i - 1) % playerNames.length]).append(": ");
			answer.append(do369(i)).append("\n");
		}

		return answer.toString();
	}

	/**
	 number 에 3,6,9가 들어 있으면 "clap" 을 리턴
	 그렇지 않으면 숫자를 string으로 변환하여 리턴
	 메소드 시그니처를 변경하지 마세요.
	 */
	private String do369(int number) {
		String numberStr = String.valueOf(number);
		if (numberStr.contains("3") || numberStr.contains("6") || numberStr.contains("9")) {
			return "clap";
		} else {
			return numberStr;
		}
	}
}

abstract class GameRegion {
	public abstract String do369(int number);
}

class SeoulRegion extends GameRegion {
	@Override
	public String do369(int number) {
		String numberStr = String.valueOf(number);
		if (numberStr.contains("3") || numberStr.contains("6") || numberStr.contains("9")) {
			return "clap";
		} else {
			return numberStr;
		}
	}
}

class BusanRegion extends GameRegion {

	@Override
	public String do369(int number) {
		String numberStr = String.valueOf(number);
		if (numberStr.contains("3") || numberStr.contains("6") || numberStr.contains("9")) {
			return "clap";
		} else {
			return numberStr;
		}
	}
}