package programmers.level0.코딩_기초_트레이닝;

//https://school.programmers.co.kr/learn/courses/30/lessons/181932 코드 처리하기
public class 코드_처리하기 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("abc1abc1abc"));
    }

    static class Solution {
        public String solution(String code) {
            String answer = "";

            int mode = 0;
            char[] ch =  code.toCharArray();

            for(int i=0; i<ch.length; i++) {
                if (ch[i] == '1') {
                    if (mode == 0) {
                        mode = 1;
                    } else {
                        mode = 0;
                    }
                    continue;
                }

                if(mode == 0) {
                    if(i % 2 == 0) {
                        answer += String.valueOf(ch[i]);
                    }
                } else {
                    if(i % 2 != 0) {
                        answer += String.valueOf(ch[i]);
                    }
                }
            }

            return "" != answer ? answer : "EMPTY";
        }
    }
}
