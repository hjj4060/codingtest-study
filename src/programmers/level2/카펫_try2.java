package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/42842
public class 카펫_try2 {
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
             * 갈색, 노랑 격자의 더한 수의 약수를 구한다.
             * 테두리가 1줄만 갈색이고, 가로가 세로보다 같거나 크다는걸 이용해서 유효성 검사를 한다.
             */

            ArrayList<Integer[]> getDivisorList = new ArrayList<>();

            int sumBrownAndYellow = brown + yellow;
            getDivisorList = getDivisorList(sumBrownAndYellow);

            answer = divisorListVaildationCheck(getDivisorList, brown);

            return answer;
        }

        /* 나눠지는 숫자 2개의 리스트 중에서 유효성 검사로 하나를 뽑는다. */
        private int[] divisorListVaildationCheck(ArrayList<Integer[]> getDivisorList, int brownCount) {
            int []widthAndHeight = new int[2];

            //유효성 검사 세로가 가로보다 큰것 제거
            for (int i = getDivisorList.size() - 1; i >= 0 ; i--) {
                if (getDivisorList.get(i)[0] < getDivisorList.get(i)[1]) {
                    getDivisorList.remove(i);
                }
            }

            //유효성 검사 brown개수가 (width * 2) + (height - 2) * 2 인것 찾기
            for (int i = getDivisorList.size() - 1; i >= 0 ; i--) {
                if (((getDivisorList.get(i)[0] * 2) + ((getDivisorList.get(i)[1] - 2) * 2)) == brownCount) {
                    widthAndHeight[0] = getDivisorList.get(i)[0];
                    widthAndHeight[1] = getDivisorList.get(i)[1];
                }
            }

            return widthAndHeight;
        }

        private ArrayList<Integer[]> getDivisorList(int sumGridCount) {
            ArrayList<Integer[]> getDivisorList = new ArrayList<>();

            int width = 0;
            int height = 0;

            //가로는 3부터 나올수 있음
            for (int i = 3; i < sumGridCount; i++) {
                if (sumGridCount % i == 0) {
                    width = i;
                    height = sumGridCount / width;

                    getDivisorList.add(new Integer[]{width, height});
                }
            }

            return getDivisorList;
        }
    }
}
