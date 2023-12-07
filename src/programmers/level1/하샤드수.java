package programmers.level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/12947
public class 하샤드수 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(10));
        System.out.println(sol.solution(12));
        System.out.println(sol.solution(11));
        System.out.println(sol.solution(13));
    }

    static class Solution {
        public boolean solution(int x) {
            boolean answer = true;

            /**
             * 풀이방법
             * 1. 하샤드 수 x를 String으로 변환한다.
             * 2. 변환한 String 값을 CharArray로 만든다.
             * 3. CharArray의 각 자릿수 숫자값을 더한다.
             * 4. 하샤드 수 % 각 자릿수 숫자값 가 0이면 true 아니면 false를 리턴한다.
             */

            String hashadNumString = "" + x;
            char[] hashadNumcharArray = hashadNumString.toCharArray();
            int hashadNumEachSum = 0;

            for (char hashadChar : hashadNumcharArray) {
                hashadNumEachSum += hashadChar - '0';
            }

            answer = (x % hashadNumEachSum) == 0.0;

            return answer;
        }
    }
}
