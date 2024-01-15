package programmers.level0.코딩테스트_입문;

import java.util.ArrayList;

public class 옷가게할인받기 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(580000));
    }

    static class Solution {
        public int solution(int price) {
            int answer = price;

            if (price >= 500000) {
                answer *= 0.80;
            } else if (price >= 300000) {
                answer *= 0.90;
            } else if (price >= 100000) {
                answer *= 0.95;
            }

            return answer;
        }
    }
}
