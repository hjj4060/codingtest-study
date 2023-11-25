package programmers.level0.코딩_기초_트레이닝;

//https://school.programmers.co.kr/learn/courses/30/lessons/181930
public class 주사위_게임2 {

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(2, 6, 1));
        System.out.println(sol.solution(5, 3, 3));
        System.out.println(sol.solution(4, 4, 4));
    }

    static class Solution {
        public int solution(int a, int b, int c) {
            int answer = 0;
            int sameCnt = 0;

            if(a == b) sameCnt += 1;
            if(a == c) sameCnt += 1;
            if(b == c) sameCnt += 1;

            switch(sameCnt){
                case 0:
                    answer = a + b + c;
                    break;
                case 1:
                    answer = (a + b + c) * ((int)Math.pow(a, 2) + (int)Math.pow(b, 2) + (int)Math.pow(c, 2));
                    break;
                case 3:
                    answer = (a + b + c) * ((int)Math.pow(a, 2) + (int)Math.pow(b, 2) + (int)Math.pow(c, 2)) * ((int)Math.pow(a, 3) + (int)Math.pow(b, 3) + (int)Math.pow(c, 3));
                    break;
            }

            return answer;
        }
    }
}

