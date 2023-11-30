package programmers.level0.코딩테스트_입문;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/120907
public class OX퀴즈 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(Arrays.toString(sol.solution(new String[]{"3 - 4 = -3", "5 + 6 = 11"})));
    }

    static class Solution {
        public String[] solution(String[] quiz) {
            String[] answer = {};
            answer = new String[quiz.length];

            /**
             * 설계
             * 1. 공백 단위로 문자열을 자른다.
             * 2. 숫자는 문자열을 숫자로 바꾸고, 부등호 연산자는 if로
             * index 0 : 앞 숫자
             * index 1 : 연산자
             * index 2 : 뒷 숫자
             * index 3 : 부등호
             * index 4 : 계산 값
             */

            for(int i=0; i<quiz.length; i++) {
                String[] splitedStr = quiz[i].split(" ");

                Double a = Double.parseDouble(splitedStr[0]);
                Double b = Double.parseDouble(splitedStr[2]);
                Double result = 0.0;

                switch(splitedStr[1]) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        result = a / b;
                        break;
                }

                if(result == Double.parseDouble(splitedStr[4])) {
                    answer[i] = "O";
                } else {
                    answer[i] = "X";
                }
            }

            return answer;
        }
    }
}
