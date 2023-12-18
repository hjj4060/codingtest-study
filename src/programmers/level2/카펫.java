package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/42842
public class 카펫 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] a = new int[]{1,2};
        int[] b = new int[]{3,4};


        //System.out.println(Arrays.toString(sol.solution(10, 2)));
        //System.out.println(Arrays.toString(sol.solution(8, 1)));
        //System.out.println(Arrays.toString(sol.solution(24, 24)));
        System.out.println(Arrays.toString(sol.solution(50, 22)));
    }

    static class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];

            /**
             * 문제풀이
             * brown + yellow 격자수로 소인수 분해 리스트를 만든다
             * 소인수 분해돼서 나온 개수가 짝수 개면  개수 반으로 나눠서 곱한걸 배열에 담고
             * 홀수개면 앞에꺼 하나 더 추가해서 곱한걸 가로 나머지 곱한값을 세로로 한다.
             */
            int sumGridCound =  brown + yellow;
            ArrayList<Integer> dividedValueList = getPrimeNumberList(sumGridCound);


            return answer;
        }

        //주어진 값에 대해서 소인수 분해 리스트를 담는다
        private ArrayList<Integer> getPrimeNumberList(int sumGridCound) {
            ArrayList<Integer> dividedValueList = new ArrayList<Integer>();

            while(sumGridCound > 1) {
                for(int i = 2; i <= sumGridCound; i++) {
                    if(sumGridCound % i == 0) {
                        dividedValueList.add(i);
                        sumGridCound /= i;

                        break;
                    }
                }
            }

            return dividedValueList;
        }
    }
}
