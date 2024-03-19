package programmers.community_learning.week2;

public class NumberOfCorrectParentheses2 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(3));
    }

    private static class Solution {
        public int solution(int n) {
            int dp[] = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;

            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i] += dp[i-j] * dp[j-1];
                }
            }

            return dp[n];
        }
    }
}
