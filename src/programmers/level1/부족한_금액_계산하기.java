package programmers.level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/82612
public class 부족한_금액_계산하기 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(3, 20, 4));
    }

    static class Solution {
        public long solution(int price, int money, int count) {
            long answer = 0;
            long amountOfcount = 0;

            for(long i = 1; i <= count; i++) {
                amountOfcount += i * price;
            }

            if(amountOfcount > money) {
                answer = amountOfcount - money;
            }

            return answer;
        }
    }
}