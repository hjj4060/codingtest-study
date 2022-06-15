package programmers.community_learning.week1;

import java.util.*;

public class MidtermExamTest {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] people = new int[]{1,2,2,2};
        int[] tshirts= new int[]{1,2,3,2};

        System.out.println(sol.solution(people, tshirts));
    }

    private static class Solution {
        public int solution(int[] people, int[] tshirts) {
            int answer = 0;
            for (int tshirt : tshirts) {
                for (int i = 0, peopleCnt = people.length; i < peopleCnt; i++) {
                    if (people[i] <= tshirt) {
                        answer++;
                        people[i] = 1001;
                        break;
                    }

                }
            }

            return answer;
        }
    }
}
