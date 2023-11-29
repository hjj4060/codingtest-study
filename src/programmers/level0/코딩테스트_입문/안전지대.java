package programmers.level0.코딩테스트_입문;

public class 안전지대 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] board = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}
        };
        System.out.println(sol.solution(board));
    }

    static class Solution {
        public int solution(int[][] board) {
            int answer = 0;

            /**
             * 설계
             * 1을 찾아서 포문을 돈 후 1을 찾으면 1의 위치 기준으로 아래 위치를 찾아 checkSafeZoneBoard 에서 1로 변경한다.
             * (-1, +1), (0, +1), (1,1),
             * (-1,0), (0, 0), (+1, 0),
             * (-1,-1), (0,-1), (+1, -1)
             * 다 1로 변경 후 checkSafeZoneBoard에서 0인 개수를 뽑는다
             */
            
            int[][] checkSafeZoneBoard = new int[board.length][board.length];

            for(int i = 0; i<board.length; i++) {
                for(int j = 0; j<board[i].length; j++) {
                    if(board[i][j] == 1) {
                        checkSafeZoneBoard[i][j] = 1;

                        if((i-1 >=0) && (j-1 >= 0)) {
                            checkSafeZoneBoard[i - 1][j - 1] = 1;
                        }

                        if(j-1 >= 0) {
                            checkSafeZoneBoard[i][j - 1] = 1;
                        }

                        if((i+1 < board.length) && (j-1 >= 0)){
                            checkSafeZoneBoard[i + 1][j - 1] = 1;
                        }

                        if(i-1 >= 0) {
                            checkSafeZoneBoard[i - 1][j] = 1;
                        }

                        if(i+1 < board.length) {
                            checkSafeZoneBoard[i + 1][j] = 1;
                        }

                        if((i-1 >= 0) && (j+1 < board.length)) {
                            checkSafeZoneBoard[i - 1][j + 1] = 1;
                        }

                        if(j+1 < board.length) {
                            checkSafeZoneBoard[i][j + 1] = 1;
                        }

                        if(i+1 < board.length && j+1 < board.length) {
                            checkSafeZoneBoard[i + 1][j + 1] = 1;
                        }
                    }
                }
            }

            for(int i = 0; i<board.length; i++) {
                for(int j = 0; j<board[i].length; j++) {
                    if(checkSafeZoneBoard[i][j] == 0) answer++;
                }
            }

            return answer;
        }
    }
}
