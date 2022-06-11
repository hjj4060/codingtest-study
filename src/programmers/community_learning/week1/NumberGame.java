package programmers.community_learning.week1;

import java.util.ArrayList;
import java.util.Collections;

//https://programmers.co.kr/learn/courses/30/lessons/12987 숫자게임
public class NumberGame {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int A[] = new int[]{5,1,3,7};
        int B[] = new int[]{2,2,6,8};

        System.out.println(sol.solution(A, B));
    }

    private static class Solution {
        public int solution(int[] A, int[] B) {
            int answer = 0;
            ArrayList<Integer> A_list = new ArrayList<>();
            ArrayList<Integer> B_list = new ArrayList<>();

            for (Integer integer : A) {
                A_list.add(integer);
            }

            for (Integer integer : B) {
                B_list.add(integer);
            }

            Collections.sort(A_list, Collections.reverseOrder());
            Collections.sort(B_list, Collections.reverseOrder());

            while (!A_list.isEmpty()) {
                int A_num = A_list.get(0);
                int B_num = B_list.get(0);

                if (A_num < B_num) {
                    A_list.remove(0);
                    B_list.remove(0);
                    answer++;

                } else {
                    A_list.remove(0);
                }
            }

            return answer;
        }
    }
}
