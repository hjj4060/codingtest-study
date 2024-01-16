package programmers.level0.코딩테스트_입문;

import java.util.ArrayList;

public class 점의위치구하기 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(new int[]{-7, 9}));
    }

    static class Solution {
        public int solution(int[] dot) {
            int answer = 0;

            if(dot[0] >= 0 && dot[1] >= 0) {
                answer = 1;
            } else if(dot[0] < 0 && dot[1] >= 0) {
                answer = 2;
            } else if(dot[0] < 0 && dot[1] < 0) {
                answer = 3;
            } else {
                answer = 4;
            }

            return answer;
        }
    }
}
