package programmers.community_learning.week1;

import java.util.Collections;
import java.util.Comparator;

//https://programmers.co.kr/learn/courses/30/lessons/42746
public class BiggestNumber {
    static Solution sol = new Solution();

    public static void main(String[] args) {
        int numbers[] = new int[]{6, 10, 2};

        System.out.println(sol.solution(numbers));
    }

    private static class Solution {
        public int solution(int numbers[]) {
           /* Collections.sort(numbers, new Comparator<Integer>() {

                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
*/
            int answer = 0;



            return answer;
        }
    }
}
