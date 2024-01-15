package programmers.level0.코딩테스트_입문;

import java.util.ArrayList;

//https://school.programmers.co.kr/learn/courses/30/lessons/120833
public class 배열자르기 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(new int[]{1, 2, 3, 4, 5}, 1, 3));
    }
    static class Solution {
        public int[] solution(int[] numbers, int num1, int num2) {
            int[] answer = null;

            ArrayList<Integer> list = new ArrayList<>();

            for (int i = num1; i <= num2; i++) {
                list.add(numbers[i]);
            }

            answer = new int[list.size()];

            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }

            return answer;
        }
    }
}
