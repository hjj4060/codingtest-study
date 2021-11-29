package baekjoon.stepbystep.OneDimensionArray;

import java.util.ArrayList;
import java.util.Scanner;

//https://www.acmicpc.net/problem/10818

/**
 * 문제
 * N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다.
 * 모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.
 */
public class MinMax {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();

        new MinMax().solve(N);
    }
    public void solve(int N) {
        ArrayList<Integer> al = new ArrayList<>();

        for(int i=0; i<N; i++) {
            al.add(sc.nextInt());
        }
        int min = al.get(0);
        int max = al.get(0);

        for (int i : al) {
            if(min > i) min = i;
            if(max < i) max = i;
        }
        System.out.println(min + " " + max);
    }
}
