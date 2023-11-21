package programmers.level0.코딩_기초_트레이닝;

import java.util.Arrays;
import java.util.Scanner;

//https://school.programmers.co.kr/learn/courses/30/lessons/181889
public class 문자열_섞기 {

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("aaaa", "bbbb"));
    }

    static class Solution {
        public String solution(String str1, String str2) {
            String answer = "";

            char[] ch1 = str1.toCharArray();
            char[] ch2 = str2.toCharArray();

            for(int i=0; i<str1.length(); i++) {
                answer += (String.valueOf(ch1[i]) + String.valueOf(ch2[i]));
            }

            return answer;
        }
    }
}

