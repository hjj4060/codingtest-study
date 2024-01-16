package programmers.level0.코딩테스트_입문;

public class 아이스_아메리카노 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        //System.out.println(sol.solution());
    }

    static class Solution {
        public int[] solution(int money) {
            int[] answer = new int[2];

            answer[0] = money / 5500;
            answer[1] = money % 5500;

            return answer;
        }
    }
}
