package baekjoon.classfication.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1182ㄴ
public class 부분수열의합_1182 {
    static int N, S;
    static int[] sequence;
    static int[] result;
    static ArrayList<int[]> resultList = new ArrayList<int[]>();
    static boolean[] isVisited = new boolean[N];

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        sequence = new int[N + 1];
        isVisited = new boolean[N + 1];
        result = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
        print();
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        int resultCnt = 0;

        for (int[] arr : resultList) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            if (sum == S) {
                resultCnt++;
            }
        }
        System.out.println(resultCnt);
    }

    private static void solve() {
        for (int i = 1; i <= N; i++) {
            recur(1, 0, i);
        }
    }

    private static void recur(int start, int depth, int returnDepth) {
        if (depth == returnDepth) {
            int[] arr = result.clone();
            resultList.add(arr);
            return;
        }
        for (int i = start; i <= N; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                result[depth] = sequence[i];
                recur(i + 1, depth + 1, returnDepth);
                isVisited[i] = false;
            }
        }
    }
}
