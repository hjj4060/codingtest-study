package community_learning.week1;

//https://programmers.co.kr/learn/courses/30/lessons/12979 기지국 설치
public class BaseStationInstallation {
    static Solution sol = new Solution();

    public static void main(String[] args) {
        int n = 11;
        int stations[] = {4, 11};
        int w = 1;

        sol.solution(n, stations, w);
    }

    private static class Solution {
        public int solution(int n, int[] stations, int w) {
            //기지국 전파전달 유무
            boolean check[] = new boolean[n + 1];
            check[0] = true;




            int answer = 0;

            // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
            System.out.println("Hello Java");

            return answer;
        }
    }
}
