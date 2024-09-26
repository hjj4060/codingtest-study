package programmers.coding_test;

public class dewhale2 {
	public static void main(String[] args) {

	}
}

class Solution2 {
	public String solution(String[] playerNames, int[] errorRates, int maxGameCount, int[] randomValues) {
		Player[] players = new Player[playerNames.length];
		//playerNames, errorRates 를 사용하여 players 만드는 코드를 작성해주세요.
		for (int i = 0; i < players.length; i++) {
			players[i].name = playerNames[i];
			players[i].errorRate = errorRates[i];
		}

		return playGame(players, maxGameCount, new Random(maxGameCount, randomValues));
	}

	private String playGame(Player[] players, int maxGameCount, Random random) {
		StringBuilder answer = new StringBuilder();
		//players 가 돌아가면서 자신의 오답율에 따라 응답하고
		//(오답을 계산시는 제공되는 random 함수를 사용해주세요.)
		//모두가 정답을 얘기하는경우 maxGameCount까지 게임을 진행

		for (int i = 1; i <= maxGameCount; i++) {
			answer.append(players[(i - 1) % players.length].getName()).append(": ");
			// answer.append(do369(i)).append("\n");
			// Random random1 = new Random(maxGameCount, players[(i - 1) % players.length].getErrorRate());

		}

		return answer.toString();
	}

	private String do369(int number) {
		String numberStr = String.valueOf(number);
		if (numberStr.contains("3") || numberStr.contains("6") || numberStr.contains("9")) {
			return "clap";
		} else {
			return numberStr;
		}
	}

	static class Player {

		private String name;

		private int errorRate;

		public Player(String name, int errorRate) {
			this.name = name;
			this.errorRate = errorRate;
		}

		public String getName() {
			return name;
		}

		public int getErrorRate() {
			return errorRate;
		}
	}

	/**
	 * 이 클래스는 수정하지 마세요.
	 */
	static private class Random {

		private int currentCount;

		private int maxCount;

		private int[] randomValues;

		public Random(int maxCount, int[] randomValues) {
			if (randomValues.length != maxCount) {
				throw new IllegalArgumentException("Random 클래스 초기화 실패");
			}
			this.maxCount = maxCount;
			this.randomValues = randomValues;
		}

		/**
		 * 0~99까지의 값을 리턴하는 함수 각 숫자는 모두 나올 확율이 같다고 가정하면된다.
		 */
		public int getNextInt() {
			return randomValues[currentCount++];
		}
	}
}
