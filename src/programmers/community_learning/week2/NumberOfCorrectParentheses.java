package programmers.community_learning.week2;

public class NumberOfCorrectParentheses {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(4));
    }

    private static class Solution {
        int count;
        public int solution(int n) {
            count = 0;

            dfs(0, 0, n);
            return count;
        }

        private void dfs(int left, int right, int n) {
            if(left < right) return;

            if (left == n && right == n) {
                count++;
                return;
            }

            if (left > n || right > n) {
                return;
            }

            dfs(left + 1, right, n);
            dfs(left, right + 1, n);
        }
    }
}
