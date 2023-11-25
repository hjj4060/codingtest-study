package programmers.level0.코딩_기초_트레이닝;

import java.util.Arrays;
import java.util.Scanner;

//https://school.programmers.co.kr/learn/courses/30/lessons/181889
public class n_번째_원소까지 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num_list = new int[]{2,1,6};

        Solution sol = new Solution();

        System.out.println(Arrays.toString(sol.solution(num_list, n)));
    }

    static class Solution {
        public int[] solution(int[] num_list, int n) {
            int[] answer = new int[n];

            for(int i=0; i<n; i++) {
                answer[i] = num_list[i];
            }

            return answer;
        }
    }
}

