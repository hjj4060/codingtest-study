package programmers.level1;


//https://school.programmers.co.kr/learn/courses/30/lessons/86491
public class 최소직사각형 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
    }

    static class Solution {
        public int solution(int[][] sizes) {
            int answer = 0;

            /**
             * 문제풀이
             * 1. 배열을 만들고 세로가 가로보다 크다면 회전 시킴
             * 2. 가로중에서 제일 큰 숫자, 세로중에서 제일 큰 숫자를 곱해서 return
             */

            int[][] rotatedCards = rotateCards(sizes);

            int maxWidth = 0;
            int maxLendth = 0;

            for(int i = 0; i < rotatedCards.length; i++) {
                maxWidth = Math.max(maxWidth, rotatedCards[i][0]);
                maxLendth = Math.max(maxLendth, rotatedCards[i][1]);
            }

            return maxWidth * maxLendth;
        }

        private int[][] rotateCards(int[][] cards) {
            int[][] rotatedCard = new int[cards.length][2];

            for(int i = 0; i < cards.length; i++) {
                int width = cards[i][0];
                int length = cards[i][1];

                if(width < length) {
                    rotatedCard[i][0] = length;
                    rotatedCard[i][1] = width;
                } else {
                    rotatedCard[i][0] = width;
                    rotatedCard[i][1] = length;
                }
            }

            return rotatedCard;
        }
    }
}
