package baekjoon.solvedac.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/11501
public class BJ11501_주식_try3 {
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

            long[] maxStockPriceAndIndex = maxStockPrice(0);
            long maxStockPrice = maxStockPriceAndIndex[0];
            long maxStockIndex = maxStockPriceAndIndex[1];
            long sellMoney = 0;
            long stockCount = 0;
            long sumStockPrice = 0;

            if (maxStockIndex == 0) {
                sb.append(sellMoney).append("\n");
                continue;
            }

            int day = 0;
            while (maxStockIndex >= day) {
                System.out.println("while문 돌았따.");
                if (day == stocks.length) {
                    break;
                }

                if (maxStockIndex != day) {
                    sumStockPrice += stocks[day];
                    stockCount++;
                    day++;
                } else {
                    sellMoney += (stockCount * maxStockPrice) - sumStockPrice;
                    day++;

                    maxStockPriceAndIndex = maxStockPrice(day);
                    maxStockPrice = maxStockPriceAndIndex[0];
                    maxStockIndex = maxStockPriceAndIndex[1];

                    stockCount = 0;
                    sumStockPrice = 0;
                }
            }

            sb.append(sellMoney).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static long[] maxStockPrice(int startIndex) {
        long maxStockPrice = 0;
        long maxStockIndex = 0;

        for (int i = startIndex; i < stocks.length; i++) {
            if (maxStockPrice <= stocks[i]) {
                maxStockPrice = stocks[i];
                maxStockIndex = i;
            }
        }

        return new long[]{maxStockPrice, maxStockIndex};
    }
}
