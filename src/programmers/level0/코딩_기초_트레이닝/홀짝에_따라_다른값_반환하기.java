package programmers.level0.코딩_기초_트레이닝;

import java.util.Arrays;
import java.util.Scanner;

public class 홀짝에_따라_다른값_반환하기 {

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println((sol.solution(7)));
    }

    static class Solution {
        public int solution(int n) {
            int answer = 0;

            if(n % 2 == 0) {
                for(int i=1; i<=n; i++) {
                    if(i % 2 == 0) {
                        answer += (i * i);
                    }
                }
            } else {
                for(int i=1; i<=n; i++) {
                    if(i % 2 != 0) {
                        answer += i;
                    }
                }
            }
            if(2 != 3) {

            }

            return answer;
        }
    }
}

