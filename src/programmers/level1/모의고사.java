package programmers.level1;

import java.util.ArrayList;
import java.util.List;

//https://school.programmers.co.kr/learn/courses/30/lessons/42840
public class 모의고사 {
	public static void main(String[] args) {
		모의고사 a = new 모의고사();

		System.out.println(a.solution(new int[] {1, 3, 2, 4, 2}));
		System.out.println(a.solution(new int[] {1, 2, 3, 4, 5}));
	}

	public List<Integer> solution(int[] answers) {
		List<Integer> answer = new ArrayList<>();

		int[] human1 = {1, 2, 3, 4, 5};
		int[] human2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] human3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

		int human1CorrectCnt = 0;
		int human2CorrectCnt = 0;
		int human3CorrectCnt = 0;
		int maxCollectCnt = 0; //정답 개수가 가장 큰수

		//정답개수를 구하고, 정답개수중 가장 큰수를 구해서 그 사람만 배열에 추가 해서 정답출력
		for (int i = 0; i < answers.length; i++) {
			int human1Idx = i % (human1.length);
			int human2Idx = i % (human2.length);
			int human3Idx = i % (human3.length);

			if (human1[human1Idx] == answers[i]) {
				human1CorrectCnt++;
			}

			if (human2[human2Idx] == answers[i]) {
				human2CorrectCnt++;
			}

			if (human3[human3Idx] == answers[i]) {
				human3CorrectCnt++;
			}
		}

		//정답 개수중 가장 큰수를 구하기
		maxCollectCnt = Math.max(human1CorrectCnt, human2CorrectCnt);
		maxCollectCnt = Math.max(maxCollectCnt, human3CorrectCnt);

		if (maxCollectCnt == 0) {
			return answer;
		}

		//정답 개수가 같은 수 만큼 배열 크기 생성
		if (maxCollectCnt == human1CorrectCnt) {
			answer.add(1);
		}

		if (maxCollectCnt == human2CorrectCnt) {
			answer.add(2);
		}

		if (maxCollectCnt == human3CorrectCnt) {
			answer.add(3);
		}

		return answer;
	}
}
