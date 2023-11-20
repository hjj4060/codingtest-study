package programmers.level0.코딩_기초_트레이닝;

import java.util.Scanner;

//https://school.programmers.co.kr/learn/courses/30/lessons/181943
public class 문자열_겹쳐쓰기 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String my_string = sc.next();
//        String overwrite_string = sc.next();
//        int s = sc.nextInt();
//
//        System.out.println(my_string);
//        System.out.println(overwrite_string);
//        System.out.println(s);
//
//        Solution.solution(my_string, overwrite_string, s);


        System.out.println(Solution.solution("He11oWor1d", "lloWorl", 2));
    }

    static class Solution {
        public static String solution(String my_string, String overwrite_string, int s) {
            String answer = "";

            answer = my_string.substring(0, s) + overwrite_string + my_string.substring(s + overwrite_string.length()) ;

            return answer;
        }
    }
}


