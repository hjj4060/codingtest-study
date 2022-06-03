package programmers.community_learning.week1;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/12979 기지국 설치
//https://small-stap.tistory.com/81 참고
public class BaseStationInstallation {
    static Solution sol = new Solution();

    public static void main(String[] args) {
        int n = 11;
        int stations[] = {4, 11};
        int w = 1;

        System.out.println(sol.solution(n, stations, w));
    }

    private static class Solution {
        public int solution(int n, int[] stations, int w) {
            //기지국 전파 체크
            boolean visit[] = new boolean[n + 1];
            visit[0] = true;

            for (int station : stations) {
                for (int i = station - w; i <= station + w; i++) {
                    if (i >= 1 && i <= n && !visit[i]) {
                        visit[i] = true;
                    }
                }
            }

            System.out.println(Arrays.toString(visit));

            //기지국 설치 개수
            int answer = 0;

            //전파 전달안되는 아파트 체크(아파트 위치 position)
            int position = 1;

            while (position <= n) {
                if (visit[position]) {
                    position++;
                } else {
                    answer++;
                    position = position + ((w * 2) + 1);
                }
            }

            return answer;
        }
    }
}
