package programmers.level0.코딩테스트_입문;

import java.util.ArrayList;
import java.util.Arrays;

public class 배열뒤집기 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(Arrays.toString(sol.solution(new int[]{1, 1, 1, 1, 1, 2})));
    }

    static class Solution {
        public int[] solution(int[] num_list) {
            int arrSize = num_list.length;
            int[] answer = new int[arrSize];

            for (int i = 0; i < arrSize; i++) {
                answer[i] = num_list[arrSize - (i + 1)];
            }

            return answer;
        }
    }
}
