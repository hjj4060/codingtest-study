package programmers.community_learning.week1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//https://programmers.co.kr/learn/courses/30/lessons/42746 가장 큰 수
public class BiggestNumber {
    static Solution sol = new Solution();

    public static void main(String[] args) {
        int numbers[] = new int[]{6, 10, 2,55,45,50,555,56,987};


        System.out.println(sol.solution(numbers));
    }

    private static class Solution {
        public String solution(int numbers[]) {
            //정수 배열 모두 문자열로 변경
            ArrayList<String> numbersList = new ArrayList<>();
            for (int number : numbers) {
                numbersList.add(Integer.toString(number));
            }
/*
            Collections.sort(numbersList, new Comparator<String>(){
                @Override
                public int compare(String o1, String o2) {
                    int o1_length = o1.length();
                    int o2_length = o2.length();

                    if(o1_length == o2_length) {
                        return Integer.parseInt(o2) - Integer.parseInt(o1);
                    } else {
                        if (o1_length > o2_length) {
                            for (int i = 0; i < o1_length - o2_length; i++) {
                                o2 += "0";
                            }
                        } else {
                            for (int i = 0; i < o2_length - o1_length; i++) {
                                o1 += "0";
                            }
                        }

                        return Integer.parseInt(o2) - Integer.parseInt(o1);
                    }
                }
            });
*/
            Collections.sort(numbersList, new Comparator<String>(){
                @Override
                public int compare(String o1, String o2) {

                    return (o2+o1).compareTo(o1+o2);
                }
            });

            for (String s : numbersList) {
                System.out.println(s);
            }

            if(numbersList.get(0).equals("0")) return "0";

            StringBuilder result = new StringBuilder();
            String answer = "";

            for (String s : numbersList) {
                result.append(s);
            }

            answer = result.toString();

            return answer;
        }
    }
}
