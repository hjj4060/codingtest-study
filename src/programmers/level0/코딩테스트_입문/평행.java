package programmers.level0.코딩테스트_입문;

import java.util.HashSet;

//https://school.programmers.co.kr/learn/courses/30/lessons/120875
public class 평행 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] dots = new int[][]{
                {1, 4},
                {9, 2},
                {3, 8},
                {11, 6}
        };

        System.out.println(sol.solution(dots));
    }

    static class Solution {
        public int solution(int[][] dots) {
            /**
             * 설계
             * (1,2), (3,4)
             * (1,3), (2,4)
             * (1,4), (2,3)
             * 3개의 기울기 차를 set에 저장해서 0.0이 있으면 answer 1
             */

            HashSet<Double> gradientSet = new HashSet();

            //(1,2) 기울기
            double gradient12 = (double)(dots[0][1] - dots[1][1]) / (dots[0][0] - dots[1][0]);

            //(3,4) 기울기
            double gradient34 = (double)(dots[2][1] - dots[3][1]) / (dots[2][0] - dots[3][0]);

            gradientSet.add(gradient12 - gradient34);

            //(1,3) 기울기
            double gradient13 = (double)(dots[0][1] - dots[2][1]) / (dots[0][0] - dots[2][0]);

            //(2,4) 기울기
            double gradient24 = (double)(dots[1][1] - dots[3][1]) / (dots[1][0] - dots[3][0]);

            gradientSet.add(gradient13 - gradient24);

            //(1,4) 기울기
            double gradient14 = (double)(dots[0][1] - dots[3][1]) / (dots[0][0] - dots[3][0]);

            //(2,3) 기울기
            double gradient23 = (double)(dots[1][1] - dots[2][1]) / (dots[1][0] - dots[2][0]);

            gradientSet.add(gradient14 - gradient23);

            return gradientSet.contains(0.0) ? 1 : 0;
        }
    }
}
