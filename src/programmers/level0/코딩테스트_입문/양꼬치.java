package programmers.level0.코딩테스트_입문;

public class 양꼬치 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(10, 3));
    }

    static class Solution {
        public int solution(int n, int k) {
            int answer = 0;

            int serviceBeverage = n / 10;
            k = k - serviceBeverage;

            answer = (12000 * n) + (k * 2000);

            return answer;
        }
    }
}
