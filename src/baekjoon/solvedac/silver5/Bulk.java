package baekjoon.solvedac.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/7568 벌크
public class Bulk {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int arr[][];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][2]; //세로 가로

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //test();

        int rank;
        int x, y;

        for (int k = 0; k < N; k++) {
            rank = 1;
            x = arr[k][0];
            y = arr[k][1];

            for (int i = 0; i < N; i++) {
                if (x >= arr[i][0] || y >= arr[i][1]) {
                    continue;
                } else {
                    rank++;
                }
            }
            sb.append(rank + " ");
        }

        System.out.println(sb);
    }

    private static void test() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
