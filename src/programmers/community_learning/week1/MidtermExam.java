package programmers.community_learning.week1;

import java.util.ArrayList;

public class MidtermExam {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] people = new int[]{1,2,2,2};
        int[] tshirts= new int[]{1,2,3,2};

        System.out.println(sol.solution(people, tshirts));
    }

    private static class Solution {
        public int solution(int[] people, int[] tshirts) {
            int answer = 0;

            ArrayList<Integer> tshirtsList = new ArrayList<Integer>();
            for (int tshirt : tshirts) {
                tshirtsList.add(tshirt);
            }

            for (int person : people) {
                if (tshirtsList.contains(person)) {
                    answer++;

                    tshirtsList.remove(Integer.valueOf(person));
                }
            }

            return answer;
        }
    }
}
