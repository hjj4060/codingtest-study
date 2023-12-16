package programmers.level1;

import programmers.copy;

//https://school.programmers.co.kr/learn/courses/30/lessons/12943
public class 콜라츠추측 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        //System.out.println(sol.solution(6));
        //System.out.println(sol.solution(16));
        System.out.println(sol.solution(626331));
    }

    static class Solution {
        public int solution(int num) {
            int answer = 0;
            int count = 0;
            
            //int로 하면 연산과정에서 범위가 넘어가기 때문에 long으로 바꿔줘야됨
            long collatzNum = num;

            //-1 이면 0 리턴
            if(collatzNum == 1) {
                return answer;
            }

            for(count = 1; count <= 500; count++) {
                collatzNum = collatzFunction(collatzNum);

                if(collatzNum == 1) {
                    answer = count;
                    break;
                }
            }

            //500돌아서 1이 아니면 -1 리턴
            if(collatzNum != 1) {
                answer = -1;
            }

            return answer;

        }

        long collatzFunction(long collatzNum) {
            if(collatzNum % 2 == 0) {
                collatzNum = collatzNum / 2;
            } else {
                collatzNum = (collatzNum * 3) + 1;
            }

            return collatzNum;
        }
    }
}
