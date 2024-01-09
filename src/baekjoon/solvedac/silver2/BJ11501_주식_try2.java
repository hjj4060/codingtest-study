package baekjoon.solvedac.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/11501
public class BJ11501_주식_try2 {
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

            int maxStockPrice = maxStockPrice(0);
            long sellMoney = 0;
            int stockCount = 0;
            int sumStockPrice = 0;

            for (int j = 0; j < stocks.length; j++) {
                if (maxStockPrice != stocks[j]) {
                    stockCount++;
                    sumStockPrice += stocks[j];
                } else {
                    sellMoney += (stockCount * maxStockPrice) - sumStockPrice;

                    if (j != stocks.length - 1) {
                        maxStockPrice = maxStockPrice(j + 1);
                    }
                    stockCount = 0;
                    sumStockPrice = 0;
                }
            }

            sb.append(sellMoney).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int maxStockPrice(int startIndex) {
        int maxStockPrice = 0;

        for (int i = startIndex; i < stocks.length; i++) {
            maxStockPrice = Math.max(maxStockPrice, stocks[i]);
        }

        return maxStockPrice;
    }
}
