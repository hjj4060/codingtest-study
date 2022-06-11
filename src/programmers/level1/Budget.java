package programmers.level1;


import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/12982 예산
public class Budget {
    static Solution sol = new Solution();

    public static void main(String[] args) {
        int d[] = new int[]{2,2,3,3};
        int budget = 10;

        System.out.println(sol.solution(d, budget));
    }

    private static class Solution {
        public int solution(int[] d, int budget) {
            int answer = 0;
            Arrays.sort(d);

            for (int i : d) {
                System.out.println(i);
            }

            int cost = 0;
            while (answer < d.length && (cost = d[answer] + cost) <= budget) {

                answer++;
            }

            return answer;
        }
    }
}
