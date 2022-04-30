package baekjoon.solvedac.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1149 RGB거리
public class RGBDistance {
    static int house[][];
    static int dp[][];

    public static void main(String[] args) throws IOException{
        input();



    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        house = new int[N][3];

        for (int i = 0; i < N; i++) {

        }

        //dp[0] = house[0] 초기화

        /*
            dp[0][0] 선택시 dp[1] = dp[
         */
    }
}
