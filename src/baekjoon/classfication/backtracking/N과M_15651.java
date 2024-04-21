package baekjoon.classfication.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/15651
public class N과M_15651 {
    static int N, M;
    static int[] result;
    static ArrayList<int[]> resultList = new ArrayList<int[]>();

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M];
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
        print();
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();

        resultList.forEach(arr -> {
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
        });

        System.out.println(sb.toString());
    }

    private static void solve() throws IOException {
        recur(0);
    }

    private static void recur(int depth) {
        if(depth == M) {
            int[] arr = result.clone();
            resultList.add(arr);
            return;
        }
        for (int i = 1; i <= N; i++) {
            result[depth] = i;
            recur(depth + 1);
        }
    }
}