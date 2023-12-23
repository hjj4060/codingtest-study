package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/42842
public class 카펫_try1 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(Arrays.toString(sol.solution(10, 2)));
        System.out.println(Arrays.toString(sol.solution(8, 1)));
        System.out.println(Arrays.toString(sol.solution(24, 24)));
        System.out.println(Arrays.toString(sol.solution(50, 22))); //24,3
        System.out.println(Arrays.toString(sol.solution(4004, 999999)));
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

            answer = lengthCalculation(dividedValueList);

            return answer;
        }

        private int[] lengthCalculation(ArrayList<Integer> dividedValueList) {
            ArrayList<int[]> widthAndHeightList = new ArrayList<>();

            int[] widthAndHeight = new int[]{1, 1};

            int widthStartIndex = 0;
            int heighStartIndex = 1;

            while(true) {
                for (int i = widthStartIndex; i < heighStartIndex; i++) {
                    widthAndHeight[0] *= dividedValueList.get(i);
                }

                for (int i = heighStartIndex; i < dividedValueList.size(); i++) {
                    widthAndHeight[1] *= dividedValueList.get(i);
                }

                widthAndHeightList.add(new int[]{widthAndHeight[0], widthAndHeight[1]});

                if(widthAndHeight[0] < widthAndHeight[1]) {
                    widthAndHeight[0] = 1;
                    widthAndHeight[1] = 1;
                    heighStartIndex++;
                } else {
                    break;
                }
            }

            widthAndHeight = widthAndHeightList.get(0);

            for(int i = 1; i < widthAndHeightList.size(); i++) {
                if (Math.abs(widthAndHeight[0] - widthAndHeight[1]) > Math.abs(widthAndHeightList.get(i)[0] - widthAndHeightList.get(i)[1])) {
                    widthAndHeight = widthAndHeightList.get(i);
                }
            }

            if(widthAndHeight[0] < widthAndHeight[1]) {
                int tmp = widthAndHeight[0];
                widthAndHeight[0] = widthAndHeight[1];
                widthAndHeight[1] = tmp;
            }

            return widthAndHeight;
        }

        //주어진 값에 대해서 소인수 분해 리스트를 담는다
        private ArrayList<Integer> getPrimeNumberList(int sumGridCount) {
            ArrayList<Integer> dividedValueList = new ArrayList<Integer>();

            while(sumGridCount > 1) {
                for(int i = 2; i <= sumGridCount; i++) {
                    if(sumGridCount % i == 0) {
                        dividedValueList.add(i);
                        sumGridCount /= i;

                        break;
                    }
                }
            }

            return dividedValueList;
        }
    }
}
