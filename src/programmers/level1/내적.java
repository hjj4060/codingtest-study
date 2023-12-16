package programmers.level1;

public class 내적 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        //System.out.println(sol.solution());
    }

    static class Solution {
        public int solution(int[] a, int[] b) {
            int answer = 0;

            for(int i = 0; i < a.length; i++) {
                answer += a[i] * b[i];
            }

            return answer;
        }
    }
}
