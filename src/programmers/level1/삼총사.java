package programmers.level1;

public class 삼총사 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(new int[]{-2, 3, 0, 2, -5}));
    }

    static class Solution {
        public int solution(int[] number) {
            int answer = 0;

            /**
             * 문제풀이
             * 3개로 만들수 있는 조합을 다 만들고 더해서 0이면 count + 1
             */

            for(int i = 0; i < number.length; i++) {
                for(int j = i + 1; j < number.length; j++) {
                    for(int k = j + 1; k < number.length; k++) {
                        answer += (number[i] + number[j] + number[k]) == 0 ? 1 : 0;
                    }
                }
            }

            return answer;
        }
    }
}