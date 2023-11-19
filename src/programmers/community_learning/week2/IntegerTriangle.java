package programmers.community_learning.week2;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/43105 정수삼각형
public class IntegerTriangle {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(sol.solution(triangle));
    }

    private static class Solution {
        public int solution(int[][] triangle) {
            int answer = 0;
            int dp[][] = new int[triangle.length][triangle.length];

            dp[0][0] = triangle[0][0];

            for (int i = 1; i < triangle.length; i++) {
                for (int j = 0; j < triangle[i].length; j++) {
                    if (j == 0) {
                        dp[i][j] = dp[i - 1][0] + triangle[i][0];
                    } else if (j == i) {
                        dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i][j], dp[i-1][j] + triangle[i][j]);
                    }
                }
            }
/*
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[i].length; j++) {
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }
 */

            for (int i = 0; i < triangle.length; i++) {
                answer = Math.max(answer, dp[triangle.length-1][i]);
            }

            return answer;
        }
    }
}
