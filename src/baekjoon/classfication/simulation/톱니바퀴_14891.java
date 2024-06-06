package baekjoon.classfication.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/14891
public class 톱니바퀴_14891 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	//전체 4개 톱니바퀴와 8개의 바퀴 상태, 마지막 출력값을 위한 배열
	static int[][] gear = new int[5][9];

	//돌려야할 톱니바퀴 값이 0이면 안돌리고 -1이면 반시계, 1이면 시계방향으로 회전
	static int[] isTurnGear;

	/**
	 * 톱니바퀴 번호 기준으로 왼쪽전부와 오른쪽 전부 돌릴게 있는지 체크하고 gear 배열에 값 추가. (값은 -1, 1)
	 *
	 */
	private static void input() throws IOException {
		for (int i = 1; i <= 4; i++) {
			st = new StringTokenizer(br.readLine());
			String gearStatus = st.nextToken();
			for (int j = 1; j <= 8; j++) {
				gear[i][j] = gearStatus.charAt(j - 1) - '0';
			}
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	private static void solve() throws IOException {
		st = new StringTokenizer(br.readLine());
		int rotationCnt = Integer.parseInt(st.nextToken());

		while (rotationCnt-- > 0) {
			st = new StringTokenizer(br.readLine());

			//회전시킬 톱니바퀴 넘버
			int gearNum = Integer.parseInt(st.nextToken());
			//회전시킬 방향 1은 시계방향, -1은 반시계 방향
			int turnDirection = Integer.parseInt(st.nextToken());
			isTurnGear = new int[5];

			isTurnGear[gearNum] = turnDirection;
			//왼쪽과 오른쪽 톱니바퀴 중에 회전시켜야할 톱니바퀴 체크
			checkTurnGear(gearNum);

			//톱니바퀴 회전
			turnGear();
		}

		print();
	}

	private static void print() {
		int ans = 0;
		if (gear[1][1] == 1)
			ans += 1;
		if (gear[2][1] == 1)
			ans += 2;
		if (gear[3][1] == 1)
			ans += 4;
		if (gear[4][1] == 1)
			ans += 8;

		System.out.println(ans);
	}

	private static void turnGear() {
		for (int i = 1; i <= 4; i++) {
			int temp = 0;
			//1이면 시계방향
			if (isTurnGear[i] == 1) {
				temp = gear[i][8];

				for (int j = 8; j >= 2; j--) {
					gear[i][j] = gear[i][j - 1];
				}

				gear[i][1] = temp;
			}

			//-1이면 반시계방향
			if (isTurnGear[i] == -1) {
				temp = gear[i][1];

				for (int j = 1; j <= 7; j++) {
					gear[i][j] = gear[i][j + 1];
				}

				gear[i][8] = temp;
			}
		}
	}

	private static void checkTurnGear(int gearNum) {
		//왼쪽 검사
		for (int i = gearNum; i >= 2; i--) {
			if (gear[i][7] != gear[i - 1][3]) {
				isTurnGear[i - 1] = -isTurnGear[i];
			} else {
				break;
			}
		}

		//오른쪽 검사
		for (int i = gearNum; i <= 3; i++) {
			if (gear[i][3] != gear[i + 1][7]) {
				isTurnGear[i + 1] = -isTurnGear[i];
			} else {
				break;
			}
		}
	}
}