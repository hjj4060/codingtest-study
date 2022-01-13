package baekjoon.classfication.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/11724
public class NumberOfConnectingElements {
    static FastReader scan = new FastReader();

    static int N, M;
    static int[][] arr;

    public static void main(String[] args) {
        N = scan.nextInt();
        M = scan.nextInt();

        arr = new int[N + 1][N + 1];

        int x, y;

        for (int i = 0; i < M; i++) {
            x = scan.nextInt();
            y = scan.nextInt();
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        for(int i=0; i<arr.length; i++) {
            int inArr[] = arr[i];
            for(int j=0; j<arr.length; j++) {
                System.out.print(inArr[j] + " ");
            }
            System.out.println();
        }
    }

    private static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            if(st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
