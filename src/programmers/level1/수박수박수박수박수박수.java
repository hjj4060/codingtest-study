package programmers.level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/12922
public class 수박수박수박수박수박수 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(3));
        System.out.println(sol.solution(4));
    }

    static class Solution {
        public String solution(int n) {
            String answer = "";

            for(int i = 0; i < n; i++) {
                if(i % 2 == 0) {
                    answer += "수";
                } else {
                    answer += "박";
                }
            }

            return answer;
        }
    }
}
