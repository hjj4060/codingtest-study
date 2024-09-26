package programmers.level2;

import java.util.HashMap;

//https://school.programmers.co.kr/learn/courses/30/lessons/42578?language=java
//풀이 : https://aram-su.tistory.com/22  공식을 유출해야함
public class 의상 {
	public static void main(String[] args) {
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
		String[][] clothes3 = {{"a", "A"}, {"b", "B"}, {"c", "C"}};

		System.out.println(solution(clothes3));
	}

	public static int solution(String[][] clothes) {
		int answer = 1;
		HashMap<String, Integer> clothType = new HashMap();
		for (int i = 0; i < clothes.length; i++) {
			String key = clothes[i][1];
			clothType.put(key, clothType.getOrDefault(key, 0) + 1);
		}

		for (int clothTypeCnt : clothType.values()) {
			answer *= (clothTypeCnt + 1);
		}

		return answer - 1;
	}
}
