package programmers.level0.코딩_기초_트레이닝;

//https://school.programmers.co.kr/learn/courses/30/lessons/181931
public class 등사수열의_특정한_항만_더하기 {

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println((sol.solution(3, 4, new boolean[]{true, false, false, true, true})));
    }

    static class Solution {
        public int solution(int a, int d, boolean[] included) {
            int answer = 0;
            int addTmp = a;

            for(int i=0; i<included.length; i++) {
                if(included[i]) {
                    answer += addTmp;
                }

                addTmp += d;
            }

            return answer;
        }
    }
}

