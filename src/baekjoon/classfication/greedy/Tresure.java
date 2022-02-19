package baekjoon.classfication.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1026
public class Tresure {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Integer A[] = new Integer[N];
        Integer B[] = new Integer[N];

        for (int j = 0; j < 2; j++) {
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                if (j == 0) {
                    A[i] = Integer.parseInt(st.nextToken());
                } else {
                    B[i] = Integer.parseInt(st.nextToken());
                }
            }
        }

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        int result = 0;

        for (int i = 0; i < A.length; i++) {
            result += A[i] * B[i];
        }

        System.out.println(result);
    }
}
