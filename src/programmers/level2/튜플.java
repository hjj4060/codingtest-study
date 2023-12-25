package programmers.level2;

import programmers.copy;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/64065
public class 튜플 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(Arrays.toString(sol.solution("{{20,111},{111}}")));
        System.out.println(Arrays.toString(sol.solution("{{123}}")));
        System.out.println(Arrays.toString(sol.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
    }

    static class Solution {
        public int[] solution(String s) {
            int[] answer = null;

            /**
             * 문제풀이
             * 1. {}를 지우고 ,단위로 잘라 배열을 만든다.
             * 2. 배열의 숫자값을 키값으로 나온 횟수를 value로 해서 맵을 만든다
             * 3. 키 리스트를 만들어서 value의 내림차순으로 정렬한다.
             * 4. 내림차순으로 정렬된 키를 배열에 담에 return 한다.
             */

            String[] numberList = s.replaceAll( "[{}]", "").split(",");

            HashMap<Integer, Integer> numberCountMap = new HashMap<>();

            for (String numberString : numberList) {
                int number = Integer.parseInt(numberString);
                numberCountMap.put(number, numberCountMap.get(number) != null ? numberCountMap.get(number) + 1 : 1);
            }

            List<Integer> numberCountKeyList = new ArrayList<>(numberCountMap.keySet());

            numberCountKeyList.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return numberCountMap.get(o2).compareTo(numberCountMap.get(o1));
                }
            });

            answer = new int[numberCountKeyList.size()];

            for (int i = 0; i < answer.length; i++) {
                answer[i] = numberCountKeyList.get(i);
            }

            return answer;
        }
    }
}
