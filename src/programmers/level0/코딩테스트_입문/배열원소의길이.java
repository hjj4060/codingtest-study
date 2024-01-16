package programmers.level0.코딩테스트_입문;

import java.util.Arrays;

public class 배열원소의길이 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        //System.out.println(sol.solution());
    }

    static class Solution {
        public int[] solution(String[] strlist) {
            int arrSize = strlist.length;
            int[] answer = new int[arrSize];

            for (int i = 0; i < arrSize; i++) {
                answer[i] = strlist[i].length();
            }

            //Arrays.stream(strList).mapToInt(String::length).toArray();

            return answer;
        }
    }
}
