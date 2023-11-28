package programmers.level0.코딩테스트_입문;

import java.util.HashMap;

//https://school.programmers.co.kr/learn/courses/30/lessons/120876
public class 겹치는_선분의_길이 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] lines = new int[][]{
                {0, 1},
                {2, 5},
                {3, 9}
        };
        System.out.println(sol.solution(lines));
    }

    static class Solution {
        public int solution(int[][] lines) {
            int answer = 0;

            /**
             * 설계
             * [[0, 1], [2, 5], [3, 9]] 일때 아래 값을 map 넣는다 그리고 2개 이상인것 개수를 뽑는다.
             * key : 01,  value : 개수
             * 23
             * 34
             * 45
             * 34
             * 45
             * 56
             * 67
             * 78
             * 89
             */

            HashMap<String, Integer> lineMap = new HashMap<>();

            for(int i=0; i < lines.length; i++) {
                //01, 23, 34 를 저장하기 위해서 0다음 부터 뽑고 전 숫자는 다음 숫자 -1
                for(int j=lines[i][0] + 1; j <= lines[i][1]; j++) {
                    lineMap.put(j-1 + "" + j, lineMap.get(j-1 + "" + j) == null ? 1 : lineMap.get(j-1 + "" + j) + 1);
                }
            }

            for (String key : lineMap.keySet()) {
                if(lineMap.get(key) > 1) answer++;
            }

            return answer;
        }
    }
}
