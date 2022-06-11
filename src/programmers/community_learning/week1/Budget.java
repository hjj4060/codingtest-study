package programmers.community_learning.week1;

import java.util.*;

public class Budget {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int budgets[] = new int[]{120, 110, 140, 150};
        int M = 485;
        System.out.println(sol.solution(budgets, M));
    }

    private static class Solution {
        private int solution(int[] budgets, int M) {
            int answer = 0;
            int left = 0;
            int right = 0;
            for (int budget : budgets) {
                if (budget > right) {
                    right = budget;
                }
            }

            int middle = 0;
            while (left <= right) {
                long sum = 0;
                middle = (left + right) / 2;

                for (int budget : budgets) {
                    if (budget >= middle) {
                        sum += middle;
                    }
                    else {
                        sum += budget;
                    }
                }

                if (sum > M) {
                    right = middle - 1;
                }
                else {
                    answer = middle;
                    left = middle + 1;
                }
            }

            return answer;
        }
    }
}
