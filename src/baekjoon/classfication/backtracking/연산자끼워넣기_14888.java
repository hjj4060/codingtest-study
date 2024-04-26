package baekjoon.classfication.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기_14888 {
    static int N;
    static int[] num;
    static int[] operCnt = new int[4];

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        num = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operCnt[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        input();

//        System.out.println(N);
//        for (int i = 0; i < N; i++) {
//            System.out.print(S[i] + " ");
//        }
//        System.out.println();
//        for (int i = 0; i < 4; i++) {
//            System.out.print(operCnt[i] + " ");
//        }
//        System.out.println();
    }

    private static void solve() {
        recur(num[0], 0);
    }

    private static void recur(int num, int depth) {
        if (depth == N) {
            return;
        }


    }
}
