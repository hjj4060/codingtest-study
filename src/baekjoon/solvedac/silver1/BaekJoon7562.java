package baekjoon.solvedac.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/7562 나이트의이동
public class BaekJoon7562 {
    static int chessBoard[][];
    static boolean visit[][];
    static Node start, end;

    static int dx[] = {-1, 1, 2, 2, 1, -1, -2};
    static int dy[] = {2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int I = Integer.parseInt(st.nextToken());
            chessBoard = new int[I][I];
            visit = new boolean[I][I];

            st = new StringTokenizer(br.readLine());
            start.x = Integer.parseInt(st.nextToken());
            start.y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            end.x = Integer.parseInt(st.nextToken());
            end.y = Integer.parseInt(st.nextToken());


        }
    }

    private class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
