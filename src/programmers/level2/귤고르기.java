package programmers.level2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

//https://school.programmers.co.kr/learn/courses/30/lessons/138476
public class 귤고르기 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(sol.solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(sol.solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
        System.out.println(sol.solution(1, new int[]{1}));
    }

    static class Solution {
        public int solution(int k, int[] tangerine) {
            int answer = 0;

            /**
             * 문제풀이
             * 종류별 개수를 담는 맵을 만든다.
             * 값순으로 내림차순으로 정렬한다.
             * 인덱스 몇개를 써야 k를 만들수있는지 구한다.
             */

            HashMap<Integer, Integer> tangerineSizeCount = new HashMap<>();

            for (int i = 0; i < tangerine.length; i++) {
                tangerineSizeCount.put(tangerine[i], tangerineSizeCount.get(tangerine[i]) != null ? tangerineSizeCount.get(tangerine[i]) + 1 : 1);
            }

            ArrayList<Integer> tangerineCount = new ArrayList<>(tangerineSizeCount.values());
            tangerineCount.sort(Comparator.reverseOrder());

            int num = 0;
            for(int i = 0; i < tangerineCount.size(); i++) {
                if (num < k) {
                    num += tangerineCount.get(i);

                    if (num >= k) {
                        answer = i + 1;
                        break;
                    }
                }
            }

            return answer;
        }
    }
}
