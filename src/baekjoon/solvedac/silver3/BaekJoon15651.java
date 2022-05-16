package baekjoon.solvedac.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/15651 N과 M (3)
public class BaekJoon15651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sb.append(j + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
