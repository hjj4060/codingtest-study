package baekjoon.solvedac.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/11501
public class BJ11501_주식_try1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    static int dayCount;
    static int[] stocks;

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        dayCount = Integer.parseInt(st.nextToken());
        stocks = new int[dayCount];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < dayCount; i++) {
            stocks[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());

        for (int i = 0; i < testCase; i++) {
            input();

            sb.append(solve());
        }

        System.out.println(sb.toString());
    }

    public static String solve() {
        int sellPrice = 0;

        //맨마지막 원소값이 최대값
        int maxStockPrice = stocks[stocks.length - 1];

//        for (int i = stocks.length - 2; i >= 0; i--) {
//            if () {
//
//            }
//        }

        return String.valueOf(sellPrice);
    }
}
