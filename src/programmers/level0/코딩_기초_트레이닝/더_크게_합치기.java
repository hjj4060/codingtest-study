package programmers.level0.코딩_기초_트레이닝;

import java.util.Arrays;
import java.util.Scanner;

public class 더_크게_합치기 {

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(9, 91));
    }

    static class Solution {
        public int solution(int a, int b) {
            int answer = 0;

            String str1 = "" + a + b;
            String str2 = "" + b + a;

            Integer.parseInt(str1);
            Integer.parseInt(str2);

            if(Integer.parseInt(str1) > Integer.parseInt(str2)) {
                answer = Integer.parseInt(str1);
            } else {
                answer = Integer.parseInt(str2);
            }

            return answer;
        }
    }
}

