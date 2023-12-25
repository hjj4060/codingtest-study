package baekjoon.solvedac.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1012
public class BJ1012_유기농배추 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for(int i = 0; i < T; i++) {
            int[][] cabbageMap = createCabbageMap();
        }



    }

    private static int[][] createCabbageMap() throws IOException {
        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //가로길이M 세로길이N
        int[][] cabbageMap = new int[N][M];

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            cabbageMap[y][x] = 1;
        }

        for (int i = 0; i < cabbageMap.length; i++) {
            for (int j = 0; j < cabbageMap[i].length; j++) {
                System.out.print(cabbageMap[i][j] + " ");
            }
            System.out.println();
        }

        return cabbageMap;
    }
}
