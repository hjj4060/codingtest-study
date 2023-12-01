package programmers.level0.코딩테스트_입문;

import java.util.HashMap;
import java.util.Iterator;

//https://school.programmers.co.kr/learn/courses/30/lessons/181916
public class 주사위게임3 {
    public static void main(String[] args) {
        Solution sol = new Solution();

//        System.out.println(sol.solution(2,2,2,2));
//        System.out.println(sol.solution(4,1,4,4));
//        System.out.println(sol.solution(6,3,3,6));
//        System.out.println(sol.solution(2,5,2,6));
//        System.out.println(sol.solution(6,4,2,5));

        System.out.println(sol.solution(1,4,1,1));
    }

    static class Solution {
        public int solution(int a, int b, int c, int d) {
            int answer = 0;

            /**
             * 설계
             * 1. 숫자를 키, 개수를 값으로 Map에 담는다.
             * Map의 리스트로 몇개가 같은지 알수 있고 Map의 키 값으로 어느 숫자 개수가 더 많은지 알 수 있다.
             */

            HashMap<Integer, Integer> diceResultMap = new HashMap<>();

            diceResultMap.put(a, diceResultMap.get(a) == null ? 1 : diceResultMap.get(a) + 1);
            diceResultMap.put(b, diceResultMap.get(b) == null ? 1 : diceResultMap.get(b) + 1);
            diceResultMap.put(c, diceResultMap.get(c) == null ? 1 : diceResultMap.get(c) + 1);
            diceResultMap.put(d, diceResultMap.get(d) == null ? 1 : diceResultMap.get(d) + 1);

            Iterator<Integer> diceResultKeyList = diceResultMap.keySet().iterator();

            if(diceResultMap.size() == 1) {
                answer = 1111 * a;
            } else if (diceResultMap.size() == 2) {
                if (diceResultMap.get(a) == 2) {
                    int diceValue1 = diceResultKeyList.next();
                    int diceValue2 = diceResultKeyList.next();

                    answer = (diceValue1 + diceValue2) * Math.abs(diceValue1 - diceValue2);
                } else {
                    int diceValue1 = diceResultKeyList.next();
                    int diceValue2 = diceResultKeyList.next();

                    if(diceResultMap.get(diceValue1) > diceResultMap.get(diceValue2)) {
                        answer = (int) Math.pow(((10 * diceValue1) + diceValue2), 2);
                    } else {
                        answer = (int) Math.pow(((10 * diceValue2) + diceValue1), 2);
                    }
                }
            } else if (diceResultMap.size() == 3) {
                int diceValue1 = diceResultKeyList.next();
                int diceValue2 = diceResultKeyList.next();
                int diceValue3 = diceResultKeyList.next();

                if (diceResultMap.get(diceValue1) == 2) {
                    answer = diceValue2 * diceValue3;
                } else if (diceResultMap.get(diceValue2) == 2) {
                    answer = diceValue1 * diceValue3;
                } else {
                    answer = diceValue1 * diceValue2;
                }
            } else {
                answer = a;

                if(answer > b) {
                    answer = b;
                }

                if(answer > c) {
                    answer = c;
                }

                if(answer > d) {
                    answer = d;
                }
            }

            return answer;
        }
    }
}
