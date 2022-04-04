package baekjoon.solvedac.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1463 1로 만들기
public class MakeIt2 {
    static int N;
    static int memoization[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        memoization = new int[N + 1];

        System.out.println(recur(N));
    }

    static int recur(int N) {
        if(N == 1) {
            return 0;
        }

        if (memoization[N] > 0) {
            return memoization[N];
        }

        memoization[N] = recur(N - 1) + 1;


        if (N % 3 == 0) {
            //memoization[N] = Math.min(recur(N / 3) + 1, memoization[N]);
            int save = recur(N / 3) + 1;
            if( memoization[N] > save ) memoization[N] = save;
        }

        if(N % 2 == 0) {
            //memoization[N] = Math.min(recur(N / 2) + 1, memoization[N]);
            int save = recur(N / 2) + 1;
            if( memoization[N] > save ) memoization[N] = save;
        }

        return memoization[N];
    }
}
