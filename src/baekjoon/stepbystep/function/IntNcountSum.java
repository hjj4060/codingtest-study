package baekjoon.stepbystep.function;

//https://www.acmicpc.net/problem/15596

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Java: long sum(int[] a); (클래스 이름: Test)
 * a: 합을 구해야 하는 정수 n개가 저장되어 있는 배열 (0 ≤ a[i] ≤ 1,000,000, 1 ≤ n ≤ 3,000,000)
 * 리턴값: a에 포함되어 있는 정수 n개의 합
 *
 * 1초에 1억번연산.
 */
public class IntNcountSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int a[] = new int[n];


        new IntNcountSum().sum(a);
    }

    long sum(int[] a) {
        long ans = 0;

        for(int i : a) {
            ans += i;
        }

        return ans;
    }
}