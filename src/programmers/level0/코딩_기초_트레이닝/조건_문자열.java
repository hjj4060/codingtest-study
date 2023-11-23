package programmers.level0.코딩_기초_트레이닝;

public class 조건_문자열 {

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println();
    }

    static class Solution {
        public int solution(String ineq, String eq, int n, int m) {
            int answer = 0;

            String str = ineq + eq;
            
            if(str.equals(">=")) {
                answer = n >= m ? 1 : 0;
            } else if(str.equals("<=")) {
                answer = n <= m ? 1 : 0;
            } else if(str.equals(">!")) {
                answer = n > m ? 1 : 0;
            } else {
                answer = n < m ? 1 : 0;
            }

            return answer;
        }
    }
}