package programmers.level0.코딩_기초_트레이닝;

//https://school.programmers.co.kr/learn/courses/30/lessons/181938
public class 두수의_연산값_비교하기 {

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(2, 91));
    }

    static class Solution {
        public int solution(int a, int b) {
            int answer = 0;

            String str = "" + a + b;

            if(Integer.parseInt(str) < (2 * a * b)) {
                answer = (2 * a * b);
            } else {
                answer = Integer.parseInt(str);
            }

            return answer;
        }
    }
}

