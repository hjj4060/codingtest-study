package programmers.level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/76501
public class 음양더하기 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(new int[]{4, 7, 12}, new boolean[]{true,false,true}));
    }

    static class Solution {
        public int solution(int[] absolutes, boolean[] signs) {
            int answer = 0;

            /**
             * 문제풀이
             * 배열 한개를 만들어서 부호가 붙은 숫자로 만들어주기
             */

            int signedAbsolutes[] = new int[absolutes.length];

            for(int i = 0; i < absolutes.length; i++) {
                signedAbsolutes[i] = absoluteBeSigned(absolutes[i], signs[i]);
            }

            for (int num : signedAbsolutes) {
                answer += num;
            }

            return answer;
        }

        int absoluteBeSigned(int absolute, boolean sign) {
            int num;

            if(sign) {
                num = absolute;
            } else {
                num = Integer.parseInt("-" + absolute);
            }

            return num;
        }
    }
}
